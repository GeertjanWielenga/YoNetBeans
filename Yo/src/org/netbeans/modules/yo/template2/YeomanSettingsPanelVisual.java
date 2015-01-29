package org.netbeans.modules.yo.template2;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

class YeomanSettingsPanelVisual extends JPanel {

    public YeomanSettingsPanelVisual() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new InstalledCommandPanel());
        add(new AllGeneratorsPanel());
    }

    @Override
    public String getName() {
        return "Yeoman Generators";
    }
    
}
