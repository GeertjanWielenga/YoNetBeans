package org.netbeans.modules.yo.template2;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

class YeomanSettingsPanelVisual extends JPanel {

    InstalledCommandPanel icp;

    public YeomanSettingsPanelVisual() {
        setLayout(new BorderLayout());
        icp = new InstalledCommandPanel();
//        add(icp);
//        add(new AllGeneratorsPanel());
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,icp, new AllGeneratorsPanel());
        splitPane.setOneTouchExpandable(true);
        add(splitPane, BorderLayout.CENTER);
    }

    @Override
    public String getName() {
        return "Yeoman Generators";
    }

    public String getSelectedGenerator() {
        return icp.getSelectedGenerator();
    }

}
