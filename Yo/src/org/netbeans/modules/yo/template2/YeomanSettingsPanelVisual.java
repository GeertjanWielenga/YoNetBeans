package org.netbeans.modules.yo.template2;

import java.awt.BorderLayout;
import javax.swing.JPanel;

class YeomanSettingsPanelVisual extends JPanel {

    InstalledCommandPanel icp;

    public YeomanSettingsPanelVisual() {
        setLayout(new BorderLayout());
        icp = new InstalledCommandPanel();
//        add(icp);
//        add(new AllGeneratorsPanel());
//        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,icp, new AllGeneratorsPanel());
//        splitPane.setOneTouchExpandable(true);
        add(icp, BorderLayout.CENTER);
    }

    @Override
    public String getName() {
        return "Yeoman Generators";
    }

    public String getSelectedGenerator() {
        return icp.getSelectedGenerator();
    }

}
