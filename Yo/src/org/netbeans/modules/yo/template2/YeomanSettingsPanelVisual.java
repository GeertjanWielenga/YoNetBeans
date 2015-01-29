package org.netbeans.modules.yo.template2;

import javax.swing.JPanel;
import org.openide.WizardDescriptor;
import org.openide.WizardValidationException;

public class YeomanSettingsPanelVisual extends JPanel {

    public YeomanSettingsPanelVisual() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        installedCommandPanel1 = new org.netbeans.modules.yo.template2.InstalledCommandPanel();
        allGeneratorsPanel1 = new org.netbeans.modules.yo.template2.AllGeneratorsPanel();

        installedCommandPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), org.openide.util.NbBundle.getMessage(YeomanSettingsPanelVisual.class, "YeomanSettingsPanelVisual.installedCommandPanel1.border.title"))); // NOI18N

        allGeneratorsPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), org.openide.util.NbBundle.getMessage(YeomanSettingsPanelVisual.class, "YeomanSettingsPanelVisual.allGeneratorsPanel1.border.title"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(installedCommandPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(allGeneratorsPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(installedCommandPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(allGeneratorsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.netbeans.modules.yo.template2.AllGeneratorsPanel allGeneratorsPanel1;
    private org.netbeans.modules.yo.template2.InstalledCommandPanel installedCommandPanel1;
    // End of variables declaration//GEN-END:variables

    boolean valid(WizardDescriptor wizardDescriptor) {
        return true;
    }

    void validate(WizardDescriptor d) throws WizardValidationException {
        // nothing to validate
    }

}
