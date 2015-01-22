package org.netbeans.modules.yo;

import java.io.File;
import org.netbeans.modules.yo.wizard.YoConfigurationVisualPanel;
import org.openide.filesystems.FileChooserBuilder;
import org.openide.util.NbPreferences;

public class YoCreationPanel extends javax.swing.JPanel {

    public YoCreationPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        yoFolderBrowseButton = new javax.swing.JButton();
        locationField = new javax.swing.JTextField();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(YoCreationPanel.class, "YoCreationPanel.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(yoFolderBrowseButton, org.openide.util.NbBundle.getMessage(YoCreationPanel.class, "YoCreationPanel.yoFolderBrowseButton.text")); // NOI18N
        yoFolderBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yoFolderBrowseButtonActionPerformed(evt);
            }
        });

        locationField.setEditable(false);
        locationField.setBackground(new java.awt.Color(204, 204, 204));
        locationField.setText(org.openide.util.NbBundle.getMessage(YoCreationPanel.class, "YoCreationPanel.locationField.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(locationField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yoFolderBrowseButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yoFolderBrowseButton)
                    .addComponent(locationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void yoFolderBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yoFolderBrowseButtonActionPerformed
        File home = new File(System.getProperty("user.home"));
        //Now build a file chooser and invoke the dialog in one line of code
        //"user-dir" is our unique key
        File toAdd = new FileChooserBuilder("user-dir").
                setTitle("Open File").
                setDirectoriesOnly(true).
                setDefaultWorkingDirectory(home).
                setApproveText("Open").
                showOpenDialog();
        //Result will be null if the user clicked cancel or closed the dialog w/o OK
        if (toAdd != null) {
            final String path = toAdd.getPath();
            locationField.setText(path);
            NbPreferences.forModule(YoConfigurationVisualPanel.class).put("yoProjectFolder", path);
        }
    }//GEN-LAST:event_yoFolderBrowseButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField locationField;
    private javax.swing.JButton yoFolderBrowseButton;
    // End of variables declaration//GEN-END:variables
}
