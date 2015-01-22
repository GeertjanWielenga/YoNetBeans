package org.netbeans.modules.yo;

import org.netbeans.modules.yo.wizard.YoConfigurationWizardPanel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JComponent;
import org.netbeans.modules.yo.wizard.YoGUIRegistrationWizardPanel;
import org.openide.DialogDisplayer;
import org.openide.WizardDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.awt.Actions;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.loaders.DataShadow;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle.Messages;

//@ActionID(
//        category = "Tools",
//        id = "org.netbeans.modules.yo.YoConfigurationAction"
//)
//@ActionRegistration(
//        displayName = "#CTL_DynamicActionCreatorAction"
//)
//@ActionReference(path = "Menu/Tools", position = 0)
//@Messages("CTL_DynamicActionCreatorAction=Add Yeoman Configuration...")
public final class YoConfigurationAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
//        NotifyDescriptor.InputLine message = new NotifyDescriptor.InputLine("Name:", "Set Name");
//        Object result = DialogDisplayer.getDefault().notify(message);
//        DialogDescriptor result = new DialogDescriptor(new DynamicActionsJPanel(), "New Dynamic Action");
//        if (NotifyDescriptor.YES_OPTION.equals(result)) {
//            String input = "";//message.getInputText();
//            //Create a new Action:
//        }
        List<WizardDescriptor.Panel<WizardDescriptor>> panels = new ArrayList<WizardDescriptor.Panel<WizardDescriptor>>();
        panels.add(new YoConfigurationWizardPanel());
        panels.add(new YoGUIRegistrationWizardPanel());
        String[] steps = new String[panels.size()];
        for (int i = 0; i < panels.size(); i++) {
            Component c = panels.get(i).getComponent();
            // Default step name to component name of panel.
            steps[i] = c.getName();
            if (c instanceof JComponent) { // assume Swing components
                JComponent jc = (JComponent) c;
                jc.putClientProperty(WizardDescriptor.PROP_CONTENT_SELECTED_INDEX, i);
                jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DATA, steps);
                jc.putClientProperty(WizardDescriptor.PROP_IMAGE, ImageUtilities.loadImage("org/netbeans/modules/yo/resources/yeoman-large.png", true));
                jc.putClientProperty(WizardDescriptor.PROP_AUTO_WIZARD_STYLE, true);
                jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DISPLAYED, true);
                jc.putClientProperty(WizardDescriptor.PROP_CONTENT_NUMBERED, true);
            }
        }
        WizardDescriptor wiz = new WizardDescriptor(new WizardDescriptor.ArrayIterator<WizardDescriptor>(panels));
        // {0} will be replaced by WizardDesriptor.Panel.getComponent().getName()
        wiz.setTitleFormat(new MessageFormat("{0}"));
        wiz.setTitle("New Yeoman Configuration");
        if (DialogDisplayer.getDefault().notify(wiz) == WizardDescriptor.FINISH_OPTION) {
            String displayName = wiz.getProperty("displayName").toString();
            String keyStrokes = wiz.getProperty("keyStrokes").toString();
            String configuration = wiz.getProperty("configuration").toString();
            createInstanceForAction(displayName.replace(" ", ""),keyStrokes, configuration);
        }
    }

    private void createInstanceForAction(String input, String keyStrokes, String configuration) {
        FileObject actionsFolder = findFolder("Actions/", "Yeoman");
        try {
            String actionName = "org-netbeans-yo-" + input + "-Action";
            FileObject newAction = actionsFolder.createData(actionName, "instance");
            DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            String createdAt = formatter.format(System.currentTimeMillis());
            newAction.setAttribute("createdAt", createdAt);
            newAction.setAttribute("configuration", configuration);
            newAction.setAttribute("displayName", input);
            newAction.setAttribute("iconBase", "org/netbeans/modules/yo/yo.png");
            newAction.setAttribute("methodvalue:instanceCreate",
                    Actions.class.getDeclaredMethod("alwaysEnabled",
                            ActionListener.class, String.class, String.class, boolean.class));
            newAction.setAttribute("methodvalue:delegate",
                    YoActionFactory.class.getDeclaredMethod("createGenericAction", Map.class));
            //Create a new Shortcut:
            createdShadowForShortcut(newAction, keyStrokes);
            //Create a new JMenuItem in main menu:
            createdShadowForMenuItem(newAction);
            //Create a new JButton in main toolbar:
            createdShadowForToolbarbutton(newAction);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        } catch (NoSuchMethodException ex) {
            Exceptions.printStackTrace(ex);
        } catch (SecurityException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private void createdShadowForShortcut(FileObject fo, String keyStrokes) {
        FileObject generatedFolder = findFolder("Keymaps/", "NetBeans");
        createShadowForPresenter(generatedFolder, fo, keyStrokes);
    }
    
    private void createdShadowForMenuItem(FileObject fo) {
        FileObject generatedFolder = findFolder("Menu/Tools/", "Yeoman");
        createShadowForPresenter(generatedFolder, fo, null);
    }

    private void createdShadowForToolbarbutton(FileObject fo) {
        FileObject generatedFolder = findFolder("Toolbars/", "Yeoman");
        createShadowForPresenter(generatedFolder, fo, null);
    }

    private void createShadowForPresenter(FileObject generatedFolder, FileObject fo, String keyStrokes) {
        try {
            DataFolder folderWhereShadowWillBeCreated = DataFolder.findFolder(generatedFolder);
            DataObject originalFile = DataObject.find(fo);
            DataShadow ds = DataShadow.create(folderWhereShadowWillBeCreated, originalFile);
            if (keyStrokes!=null){
                ds.rename(keyStrokes);
            }
        } catch (DataObjectNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private FileObject findFolder(String existingFolder, String newFolder) {
        FileObject generatedFolder = FileUtil.getConfigFile(existingFolder + newFolder);
        if (generatedFolder == null) {
            try {
                generatedFolder = FileUtil.getConfigFile(existingFolder).createFolder(newFolder);
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        return generatedFolder;
    }

}
