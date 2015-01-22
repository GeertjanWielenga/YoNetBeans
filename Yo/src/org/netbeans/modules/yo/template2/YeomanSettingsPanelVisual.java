package org.netbeans.modules.yo.template2;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import org.openide.WizardDescriptor;
import org.openide.WizardValidationException;

public class YeomanSettingsPanelVisual extends JPanel {

    public YeomanSettingsPanelVisual() {
        initComponents();
        DefaultListModel dlm = new DefaultListModel();
        for (String yoGenerator : YeomanHelpParser.getAvailableYoGenerators()) {
            dlm.addElement(yoGenerator);
        }
        yoGeneratorList.setModel(dlm);
    }

    public String getSelectedGenerator() {
        return (String) yoGeneratorList.getSelectedValue();
    }

    @Override
    public String getName() {
        return "Yeoman Settings";
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        yoGeneratorList = new javax.swing.JList();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(YeomanSettingsPanelVisual.class, "YeomanSettingsPanelVisual.jLabel1.text")); // NOI18N

        jScrollPane1.setViewportView(yoGeneratorList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(217, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList yoGeneratorList;
    // End of variables declaration//GEN-END:variables

    boolean valid(WizardDescriptor wizardDescriptor) {
        return true;
    }

    void validate(WizardDescriptor d) throws WizardValidationException {
        // nothing to validate
    }

}
