package org.netbeans.modules.yo.template2;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.beans.IntrospectionException;
import java.io.File;
import java.io.FilenameFilter;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.netbeans.api.annotations.common.StaticResource;
import org.netbeans.modules.yo.wizard.YoConfigurationVisualPanel;
import org.openide.awt.StatusDisplayer;
import org.openide.nodes.BeanNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.NbPreferences;
import org.openide.util.lookup.Lookups;

class InstalledCommandChildFactory extends ChildFactory<YeomanGeneratorObject> {

    private String selectedGenerator = "";

    @StaticResource
    private static final String YO = "org/netbeans/modules/yo/resources/YoIcon.png";

    public InstalledCommandChildFactory() {
        YeomanHelpParser.parseYoHelp();
    }

    @Override
    protected boolean createKeys(List<YeomanGeneratorObject> list) {
        String yo = NbPreferences.forModule(YoConfigurationVisualPanel.class).get("yoExecutableLocation", "");
        File yoInstalledPath = new File(yo.replace("yo.cmd", "node_modules"));
        String[] nodeModules = yoInstalledPath.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isDirectory();
            }
        });
        for (String nodeModule : nodeModules) {
            if (nodeModule.startsWith("generator-")) {
                list.add(new YeomanGeneratorObject(nodeModule + " (" + nodeModule.replace("generator-", "") + ")"));
            }
        }
        return true;
    }

    @Override
    protected Node createNodeForKey(final YeomanGeneratorObject key) {
        YeomanCommandNode node = null;
        try {
            node = new YeomanCommandNode(key);
        } catch (IntrospectionException ex) {
            Exceptions.printStackTrace(ex);
        }
        return node;
    }

    public String getSelectedGenerator() {
        return selectedGenerator;
    }

    private class YeomanCommandNode extends BeanNode {

        public YeomanCommandNode(YeomanGeneratorObject bean) throws IntrospectionException {
            super(bean, Children.LEAF, Lookups.singleton(bean));
            setDisplayName(bean.getName());
            setShortDescription(bean.getWebsite());
        }

        @Override
        public Action getPreferredAction() {
            return new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectedGenerator = getLookup().lookup(YeomanGeneratorObject.class).getName();
                    StatusDisplayer.getDefault().setStatusText("Selected: " + selectedGenerator);
                }
            };
        }

        @Override
        public Image getIcon(int type) {
            return ImageUtilities.loadImage(YO);
        }
    }

}
