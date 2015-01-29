package org.netbeans.modules.yo.template2;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openide.nodes.BeanNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;

class YeomanChildFactory extends ChildFactory<YeomanGeneratorObject> {

    private final int type;

    private static final String URL = "https://yeoman-generator-list.herokuapp.com";

    public YeomanChildFactory(boolean parse, int type) {
        this.type = type;
        if (parse) {
            YeomanHelpParser.parseYoHelp();
        }
    }

    @Override
    protected boolean createKeys(List<YeomanGeneratorObject> list) {
        if (type == 1) {
            for (String installedYoCommand : YeomanHelpParser.getAvailableYoCommands()) {
                list.add(new YeomanGeneratorObject(installedYoCommand));
            }
        } else if (type == 2) {
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
                    Object description = json.get("description");
                    for (String installedYoGenerator : YeomanHelpParser.getAvailableYoGenerators()) {
                        if (name.equals("generator-" + installedYoGenerator.toLowerCase())) {
                            installed = true;
                        }
                    }
                    list.add(new YeomanGeneratorObject(stars, installed, name, description.toString(), owner, website));
                }
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
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
        }

    }

}
