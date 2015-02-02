package org.netbeans.modules.yo.options;

import java.io.File;
import java.util.List;
import org.netbeans.modules.yo.wizard.YoConfigurationVisualPanel;
import org.openide.awt.StatusDisplayer;
import org.openide.filesystems.FileChooserBuilder;
import org.openide.util.NbBundle;
import org.openide.util.NbPreferences;

final class YeomanPanel extends javax.swing.JPanel {

    private final YeomanOptionsPanelController controller;

    public static final String EXECUTABLE_NAME = "yo"; // NOI18N
    public static final String EXECUTABLE_LONG_NAME = EXECUTABLE_NAME + FileUtils.getScriptExtension(true, false);
    
    YeomanPanel(YeomanOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        yoFolderBrowseButton = new javax.swing.JButton();
        yeomanPathTextField = new javax.swing.JTextField();
        yeomanPathBrowseButton = new javax.swing.JButton();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(YeomanPanel.class, "YeomanPanel.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(yoFolderBrowseButton, org.openide.util.NbBundle.getMessage(YeomanPanel.class, "YeomanPanel.yoFolderBrowseButton.text")); // NOI18N
        yoFolderBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yoFolderBrowseButtonActionPerformed(evt);
            }
        });

        yeomanPathTextField.setText(org.openide.util.NbBundle.getMessage(YeomanPanel.class, "YeomanPanel.yeomanPathTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(yeomanPathBrowseButton, org.openide.util.NbBundle.getMessage(YeomanPanel.class, "YeomanPanel.yeomanPathBrowseButton.text")); // NOI18N
        yeomanPathBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yeomanPathBrowseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yeomanPathTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yoFolderBrowseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yeomanPathBrowseButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(yeomanPathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(yoFolderBrowseButton)
                .addComponent(yeomanPathBrowseButton))
        );
    }// </editor-fold>//GEN-END:initComponents

    @NbBundle.Messages("YeomanOptionsPanel.browse.title=Select Sass")
    private void yoFolderBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yoFolderBrowseButtonActionPerformed
        File file = new FileChooserBuilder(YeomanPanel.class)
                .setFilesOnly(true)
                .setTitle(Bundle.YeomanOptionsPanel_browse_title())
                .showOpenDialog();
        if (file != null) {
            yeomanPathTextField.setText(file.getAbsolutePath());
        }
    }//GEN-LAST:event_yoFolderBrowseButtonActionPerformed

    @NbBundle.Messages("YeomanOptionsPanel.executable.notFound=No Yo executable found.")
    private void yeomanPathBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yeomanPathBrowseButtonActionPerformed
        List<String> sassPaths = FileUtils.findFileOnUsersPath(EXECUTABLE_LONG_NAME, EXECUTABLE_NAME);
        if (sassPaths.isEmpty()) {
            StatusDisplayer.getDefault().setStatusText(Bundle.YeomanOptionsPanel_executable_notFound());
        } else {
            yeomanPathTextField.setText(sassPaths.get(0));
        }
    }//GEN-LAST:event_yeomanPathBrowseButtonActionPerformed

    void load() {
        NbPreferences.forModule(YoConfigurationVisualPanel.class).get("yoExecutableLocation", "");
    }

    void store() {
        NbPreferences.forModule(YoConfigurationVisualPanel.class).put("yoExecutableLocation", yeomanPathTextField.getText());
    }

    boolean valid() {
        // TODO check whether form is consistent and complete
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton yeomanPathBrowseButton;
    private javax.swing.JTextField yeomanPathTextField;
    private javax.swing.JButton yoFolderBrowseButton;
    // End of variables declaration//GEN-END:variables
}
