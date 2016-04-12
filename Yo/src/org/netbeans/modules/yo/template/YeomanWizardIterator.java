package org.netbeans.modules.yo.template;

import java.awt.Component;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.swing.JComponent;
import javax.swing.event.ChangeListener;
import org.netbeans.api.extexecution.ExecutionDescriptor;
import org.netbeans.api.extexecution.ExecutionService;
import org.netbeans.api.extexecution.ExternalProcessBuilder;
import org.netbeans.api.extexecution.input.InputProcessor;
import org.netbeans.api.extexecution.input.InputProcessors;
import org.netbeans.api.extexecution.input.LineProcessor;
import org.netbeans.api.extexecution.print.ConvertedLine;
import org.netbeans.api.extexecution.print.LineConvertor;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressUtils;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ui.OpenProjects;
import org.openide.WizardDescriptor;
import org.netbeans.api.templates.TemplateRegistration;
import org.netbeans.modules.yo.template2.YeomanSettingsWizardPanel;
import org.netbeans.modules.yo.wizard.YoConfigurationVisualPanel;
import org.openide.awt.StatusDisplayer;
import org.openide.filesystems.FileLock;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle;
import org.openide.util.NbPreferences;
import org.openide.xml.XMLUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@TemplateRegistration(position = 300, folder = "Project/ClientSide", displayName = "#Yeoman_displayName", description = "../resources/YeomanWizardDescription.html", iconBase = "org/netbeans/modules/yo/resources/yo.png", content = "../resources/EmptyProject.zip")
@NbBundle.Messages("Yeoman_displayName=HTML5/JS Application from Yeoman")
public class YeomanWizardIterator implements WizardDescriptor.ProgressInstantiatingIterator {

    private int index;
    private WizardDescriptor.Panel[] panels;
    private WizardDescriptor wiz;
    private static final String ENCODING = "UTF-8";

    public YeomanWizardIterator() {
    }

    public static YeomanWizardIterator createIterator() {
        return new YeomanWizardIterator();
    }

    private WizardDescriptor.Panel[] createPanels() {
        return new WizardDescriptor.Panel[]{
            new YeomanSettingsWizardPanel(),
            new YeomanNameLocationWizardPanel()
        };
    }

    private String[] createSteps() {
        return new String[]{
            NbBundle.getMessage(YeomanWizardIterator.class, "LBL_HelloWorld"),
            NbBundle.getMessage(YeomanWizardIterator.class, "LBL_CreateProjectStep")
        };
    }

    @Override
    public Set instantiate(final ProgressHandle handle) throws IOException {
        ProgressUtils.showProgressDialogAndRun(new Runnable() {
            @Override
            public void run() {
                try {
                    createYoApp(handle);
                } catch (IOException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        }, "Creating Yeoman application...");
        return Collections.emptySet();
    }

    private Process process;

    private void createYoApp(final ProgressHandle handle) throws IOException {
        final File dirF = FileUtil.normalizeFile((File) wiz.getProperty("projdir"));
        final String selectedGenerator = (String) wiz.getProperty("selectedGenerator");
        dirF.mkdirs();
        handle.start(100);
        try {
            final DialogLineProcessor dialogProcessor = new DialogLineProcessor();
            Callable<Process> callable = new Callable<Process>() {
                @Override
                public Process call() throws Exception {
                    String yo = NbPreferences.forModule(YoConfigurationVisualPanel.class).get("yoExecutableLocation", "");
                    process
                            = new ExternalProcessBuilder(yo).
                            addArgument(selectedGenerator).
                            workingDirectory(dirF).call();
                    dialogProcessor.setWriter(new OutputStreamWriter(process.getOutputStream()));
                    return process;
                }
            };
            ExecutionDescriptor descriptor = new ExecutionDescriptor()
                    .frontWindow(true)
                    .inputVisible(true)
                    .postExecution(new Runnable() {
                        @Override
                        public void run() {
                            StatusDisplayer.getDefault().setStatusText("Created: " + dirF.getPath());
                        }
                    })
                    .outConvertorFactory(new ExecutionDescriptor.LineConvertorFactory() {
                        @Override
                        public LineConvertor newLineConvertor() {
                            return new Numbered();
                        }
                    })
                    .outProcessorFactory(new ExecutionDescriptor.InputProcessorFactory() {
                        @Override
                        public InputProcessor newInputProcessor(InputProcessor defaultProcessor) {
                            return InputProcessors.proxy(defaultProcessor, InputProcessors.bridge(new ProgressLineProcessor(process, handle, 100, 1)));
                        }
                    })
                    .errProcessorFactory(new ExecutionDescriptor.InputProcessorFactory() {
                        @Override
                        public InputProcessor newInputProcessor(InputProcessor defaultProcessor) {
                            return InputProcessors.proxy(defaultProcessor, InputProcessors.bridge(dialogProcessor));
                        }
                    });
            ExecutionService service = ExecutionService.newService(callable, descriptor, "Yeoman");
            Future<Integer> future = service.run();
            try {
                future.get();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException ex) {
                Exceptions.printStackTrace(ex.getCause());
            }
        } finally {
            handle.progress(100);
            handle.finish();
        }
        FileObject dir = FileUtil.toFileObject(dirF);
        dir.refresh();
        if (dir.getFileObject("pom.xml") == null) {
            FileObject nbprojectFolder = dir.createFolder("nbproject");
            FileObject projectXML = nbprojectFolder.createData("project", "xml");
            writeTemplate(projectXML,selectedGenerator);
//            FileObject projectProperties = nbprojectFolder.createData("project", "properties");
            Project p = FileOwnerQuery.getOwner(dir);
            OpenProjects.getDefault().open(new Project[]{p}, true, true);
        } else {
            Project p = FileOwnerQuery.getOwner(dir);
            OpenProjects.getDefault().open(new Project[]{p}, true, true);
        }
    }

    private void writeTemplate(FileObject obj, String name) {
        FileLock fileLock = null;
        OutputStreamWriter osw;
        try {
            fileLock = obj.lock();
            OutputStream fout = obj.getOutputStream(fileLock);
            OutputStream bout = new BufferedOutputStream(fout);
            osw = new OutputStreamWriter(bout, "UTF-8");
            osw.write(
                    "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                    + "<project xmlns=\"http://www.netbeans.org/ns/project/1\">\n"
                    + "    <type>org.netbeans.modules.web.clientproject</type>\n"
                    + "    <configuration>\n"
                    + "        <data xmlns=\"http://www.netbeans.org/ns/clientside-project/1\">\n"
                    + "            <name>"+name+"</name>\n"
                    + "        </data>\n"
                    + "    </configuration>\n"
                    + "</project>"
            );
            osw.flush();
            osw.close();
        } catch (IOException ex) {
        } finally {
            if (fileLock != null) {
                fileLock.releaseLock();
            }
        }
    }

    @Override
    public Set instantiate() throws IOException {
        assert false : "Cannot call this method if implements WizardDescriptor.ProgressInstantiatingIterator.";
        return null;
    }

    private class Numbered implements LineConvertor {

        private int number;

        @Override
        public List<ConvertedLine> convert(String line) {
            List<ConvertedLine> result = Collections.singletonList(ConvertedLine.forText(number + ": " + line, null));
            number++;
            return result;
        }
    }

    private static class DialogLineProcessor implements LineProcessor {

        private Writer writer;

        @Override
        public void processLine(String line) {
            Writer answerWriter;
            synchronized (this) {
                answerWriter = writer;
            }
            if (answerWriter != null) {
                try {
                    answerWriter.write("y\n"); // NOI18N
                    answerWriter.flush();
                } catch (IOException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        }

        public void setWriter(Writer writer) {
            synchronized (this) {
                this.writer = writer;
            }
        }

        @Override
        public void close() {
            // noop
        }

        @Override
        public void reset() {
            // noop
        }
    }

    @Override
    public void initialize(WizardDescriptor wiz) {
        this.wiz = wiz;
        index = 0;
        panels = createPanels();
        // Make sure list of steps is accurate.
        String[] steps = createSteps();
        for (int i = 0; i < panels.length; i++) {
            Component c = panels[i].getComponent();
            if (steps[i] == null) {
                // Default step name to component name of panel.
                // Mainly useful for getting the name of the target
                // chooser to appear in the list of steps.
                steps[i] = c.getName();
            }
            if (c instanceof JComponent) { // assume Swing components
                JComponent jc = (JComponent) c;
                // Step #.
                jc.putClientProperty("WizardPanel_contentSelectedIndex", new Integer(i));
                // Step name (actually the whole list for reference).
                jc.putClientProperty(WizardDescriptor.PROP_IMAGE, ImageUtilities.loadImage("org/netbeans/modules/yo/resources/yeoman-large.png", true));
                jc.putClientProperty("WizardPanel_contentData", steps);
            }
        }
    }

    public void uninitialize(WizardDescriptor wiz) {
        this.wiz.putProperty("unscrambledtextfield1", null);
        this.wiz.putProperty("projdir", null);
        this.wiz.putProperty("name", null);
        this.wiz = null;
        panels = null;
    }

    public String name() {
        return MessageFormat.format("{0} of {1}",
                new Object[]{new Integer(index + 1), new Integer(panels.length)});
    }

    public boolean hasNext() {
        return index < panels.length - 1;
    }

    public boolean hasPrevious() {
        return index > 0;
    }

    public void nextPanel() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        index++;
    }

    public void previousPanel() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        index--;
    }

    public WizardDescriptor.Panel current() {
        return panels[index];
    }

    // If nothing unusual changes in the middle of the wizard, simply:
    public final void addChangeListener(ChangeListener l) {
    }

    public final void removeChangeListener(ChangeListener l) {
    }

    private static void unZipFile(InputStream source, FileObject projectRoot) throws IOException {
        try {
            ZipInputStream str = new ZipInputStream(source);
            ZipEntry entry;
            while ((entry = str.getNextEntry()) != null) {
                if (entry.isDirectory()) {
                    FileUtil.createFolder(projectRoot, entry.getName());
                } else {
                    FileObject fo = FileUtil.createData(projectRoot, entry.getName());
                    if ("nbproject/project.xml".equals(entry.getName())) {
                        // Special handling for setting name of Ant-based projects; customize as needed:
                        filterProjectXML(fo, str, projectRoot.getName());
                    } else {
                        writeFile(str, fo);
                    }
                }
            }
        } finally {
            source.close();
        }
    }

    private static void writeFile(ZipInputStream str, FileObject fo) throws IOException {
        OutputStream out = fo.getOutputStream();
        try {
            FileUtil.copy(str, out);
        } finally {
            out.close();
        }
    }

    private static void filterProjectXML(FileObject fo, ZipInputStream str, String name) throws IOException {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            FileUtil.copy(str, baos);
            Document doc = XMLUtil.parse(new InputSource(new ByteArrayInputStream(baos.toByteArray())), false, false, null, null);
            NodeList nl = doc.getDocumentElement().getElementsByTagName("name");
            if (nl != null) {
                for (int i = 0; i < nl.getLength(); i++) {
                    Element el = (Element) nl.item(i);
                    if (el.getParentNode() != null && "data".equals(el.getParentNode().getNodeName())) {
                        NodeList nl2 = el.getChildNodes();
                        if (nl2.getLength() > 0) {
                            nl2.item(0).setNodeValue(name);
                        }
                        break;
                    }
                }
            }
            OutputStream out = fo.getOutputStream();
            try {
                XMLUtil.write(doc, out, "UTF-8");
            } finally {
                out.close();
            }
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
            writeFile(str, fo);
        }
    }

}
