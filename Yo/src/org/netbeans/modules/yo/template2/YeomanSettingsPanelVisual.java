package org.netbeans.modules.yo.template2;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

class YeomanSettingsPanelVisual extends JPanel {

    InstalledCommandPanel icp;
    public YeomanSettingsPanelVisual() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
         icp = new InstalledCommandPanel();
        add(icp);
        add(new AllGeneratorsPanel());
    }

    @Override
    public String getName() {
        return "Yeoman Generators";
    }

    public String getSelectedGenerator() {
        return icp.getSelectedGenerator();
    }
    
}
