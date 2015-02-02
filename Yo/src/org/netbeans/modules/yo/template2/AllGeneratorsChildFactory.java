package org.netbeans.modules.yo.template2;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.beans.IntrospectionException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.netbeans.api.annotations.common.StaticResource;
import org.netbeans.api.progress.ProgressUtils;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.nodes.BeanNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle;
import org.openide.util.lookup.Lookups;

class AllGeneratorsChildFactory extends ChildFactory<YeomanGeneratorObject> {

    private static final String URL = "https://yeoman-generator-list.herokuapp.com";
    private boolean filter = false;
    private String filterMessage = "Displaying all generators...";
    
    @StaticResource
    private static final String DOWNLOAD = "org/netbeans/modules/yo/resources/DownloadIcon.png";
    @StaticResource
    private static final String YO = "org/netbeans/modules/yo/resources/YoIcon.png";

    @Override
    protected boolean createKeys(final List<YeomanGeneratorObject> list) {
        ProgressUtils.showProgressDialogAndRun(new Runnable() {
            @Override
            public void run() {
                doWork(list);
            }
        }, filterMessage);
        return true;
    }

    private void doWork(List<YeomanGeneratorObject> list) throws JSONException {
        JSONArray array;
        try {
            array = (JSONArray) new JSONTokener(IOUtils.toString(new URL(URL))).nextValue();
            for (int i = 0; i < array.length(); i++) {
                JSONObject json = (JSONObject) array.get(i);
                boolean installed = false;
                int stars = json.getInt("stars");
                String name = json.getString("name");
                String owner = json.getString("owner");
                String website = json.getString("website");
                String ownerWebsite = json.getString("ownerWebsite");
                Object description = json.get("description");
                for (String installedYoGenerator : YeomanHelpParser.getAvailableYoGenerators()) {
                    if (name.equals("generator-" + installedYoGenerator.toLowerCase())) {
                        installed = true;
                    }
                }
                YeomanGeneratorObject ygo = new YeomanGeneratorObject(stars, installed, name, description.toString(), owner, website, ownerWebsite);
                if (filter == true && installed == true) {
                    list.add(ygo);
                }
                if (filter == false) {
                    list.add(ygo);
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
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

    void defineFilter(boolean filter, String filterMessage) {
        this.filter = filter;
        this.filterMessage = filterMessage;
        refresh(true);
    }

    private class YeomanGeneratorNode extends BeanNode {

        public YeomanGeneratorNode(YeomanGeneratorObject bean) throws IntrospectionException {
            super(bean, Children.LEAF, Lookups.singleton(bean));
            setDisplayName("");
        }

        @Override
        public Action[] getActions(boolean context) {
            if (getLookup().lookup(YeomanGeneratorObject.class).isInstalled()) {
                return new Action[]{};
            } else {
                return new Action[]{new AbstractAction("Install") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name = getLookup().lookup(YeomanGeneratorObject.class).getName();
                        NotifyDescriptor.Message m = new NotifyDescriptor.Message("Want to run 'npm install -g " + name + "'?");
                        Object o = DialogDisplayer.getDefault().notify(m);
                        if (o == NotifyDescriptor.OK_OPTION) {
                            NodeRunner.installYeomanGenerator(name);
                            YeomanGeneratorObject ygo = getLookup().lookup(YeomanGeneratorObject.class);
                            ygo.setInstalled(true);
                        }
                    }
                }};
            }
        }

        @Override
        public Image getIcon(int type) {
            if (getLookup().lookup(YeomanGeneratorObject.class).isInstalled()) {
                return ImageUtilities.loadImage(YO);
            } else {
                return ImageUtilities.loadImage(DOWNLOAD);
            }
        }

    }

}
