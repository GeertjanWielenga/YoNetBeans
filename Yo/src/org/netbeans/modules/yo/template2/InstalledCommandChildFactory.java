package org.netbeans.modules.yo.template2;

import java.awt.Image;
import java.beans.IntrospectionException;
import java.util.List;
import org.openide.nodes.BeanNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;

class InstalledCommandChildFactory extends ChildFactory<YeomanGeneratorObject> {

    public InstalledCommandChildFactory() {
        YeomanHelpParser.parseYoHelp();
    }

    @Override
    protected boolean createKeys(List<YeomanGeneratorObject> list) {
        for (String installedYoCommand : YeomanHelpParser.getAvailableYoCommands()) {
            list.add(new YeomanGeneratorObject(installedYoCommand));
        }
        return true;
    }

    @Override
    protected Node createNodeForKey(final YeomanGeneratorObject key) {
        YeomanGeneratorNode node = null;
        try {
            node = new YeomanGeneratorNode(key);
        } catch (IntrospectionException ex) {
            Exceptions.printStackTrace(ex);
        }
        return node;
    }

    private class YeomanGeneratorNode extends BeanNode {
        public YeomanGeneratorNode(YeomanGeneratorObject bean) throws IntrospectionException {
            super(bean);
            setDisplayName(bean.getName());
            setShortDescription(bean.getWebsite());
        }
        @Override
        public Image getIcon(int type) {
            return ImageUtilities.loadImage("org/netbeans/modules/yo/resources/yo.png");
        }
    }

}
