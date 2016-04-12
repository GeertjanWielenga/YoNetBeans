package org.netbeans.modules.yo.template2;

import java.beans.IntrospectionException;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.nodes.BeanNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;

class YeomanCommandChildFactory extends ChildFactory<FileObject> {

    private final YeomanGeneratorObject bean;

    public YeomanCommandChildFactory(YeomanGeneratorObject bean) {
        this.bean = bean;
    }

    @Override
    protected boolean createKeys(List<FileObject> list) {
        FileObject generatorsFolder = FileUtil.toFileObject(new File(bean.getGeneratorsPath()));
        System.out.println("generatorsFolder = " + generatorsFolder);
        list.addAll(Arrays.asList(generatorsFolder.getChildren()));
        return true;
    }

    @Override
    protected Node createNodeForKey(FileObject key) {
        BeanNode node = null;
        try {
            node = new BeanNode(bean);
            node.setDisplayName(key.getName());
        } catch (IntrospectionException ex) {
            Exceptions.printStackTrace(ex);
        }
        return node;
    }

}
