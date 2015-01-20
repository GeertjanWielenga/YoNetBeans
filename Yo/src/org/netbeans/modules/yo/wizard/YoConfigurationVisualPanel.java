package org.netbeans.modules.yo.wizard;

import java.io.File;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import org.netbeans.modules.yo.utils.ShortcutEnterPanel;
import org.netbeans.modules.yo.utils.WizardUtils;
import org.openide.filesystems.FileChooserBuilder;
import org.openide.util.NbPreferences;

public final class YoConfigurationVisualPanel extends JPanel {

    private static final String TEMPLATE = "import java.awt.event.ActionEvent;\n"
            + "import java.awt.event.ActionListener;\n"
            + "import javax.swing.JOptionPane;\n"
            + "\n"
            + "public class MyActionListener implements ActionListener {\n"
            + "    @Override\n"
            + "    public void actionPerformed(ActionEvent e) {\n"
            + "        JOptionPane.showMessageDialog(null, \"hello world\");\n"
            + "    }\n"
            + "}";

    private KeyStroke[] keyStrokes;

    public YoConfigurationVisualPanel() {
        initComponents();
        //Create a Java Editor in the JEditorPane:
//        EditorKit kit = CloneableEditorSupport.getEditorKit("text/x-java");
//        editorPane.setEditorKit(kit);
//        FileObject fob;
//        try {
//            fob = FileUtil.getConfigRoot().getFileObject("tmp.java");
//            if (fob == null) {
//                fob = FileUtil.getConfigRoot().createData("tmp.java");
//            }
//            DataObject dob = DataObject.find(fob);
//            editorPane.getDocument().putProperty(
//                    Document.StreamDescriptionProperty,
//                    dob);
//            DialogBinding.bindComponentToFile(fob, 0, 0, editorPane);
//            editorPane.setText(TEMPLATE);
//        } catch (IOException ex) {
//            Exceptions.printStackTrace(ex);
//        }
    }

//    public String getDisplayNameTextField() {
//        return displayNameTextField.getText();
//    }
//    public String getKeyStrokes() {
//        return WizardUtils.keyStrokesToLogicalString(keyStrokes);
//    }
    public String getParameters() {
        return parametersTextField.getText();
    }

    @Override
    public String getName() {
        return "Yeoman Settings";
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        parametersTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        locationField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(YoConfigurationVisualPanel.class, "YoConfigurationVisualPanel.jLabel3.text")); // NOI18N

        parametersTextField.setText(org.openide.util.NbBundle.getMessage(YoConfigurationVisualPanel.class, "YoConfigurationVisualPanel.parametersTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(YoConfigurationVisualPanel.class, "YoConfigurationVisualPanel.jLabel4.text")); // NOI18N

        locationField.setText(org.openide.util.NbBundle.getMessage(YoConfigurationVisualPanel.class, "YoConfigurationVisualPanel.locationField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(browseButton, org.openide.util.NbBundle.getMessage(YoConfigurationVisualPanel.class, "YoConfigurationVisualPanel.browseButton.text")); // NOI18N
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBox1, org.openide.util.NbBundle.getMessage(YoConfigurationVisualPanel.class, "YoConfigurationVisualPanel.jCheckBox1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(YoConfigurationVisualPanel.class, "YoConfigurationVisualPanel.jLabel5.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(locationField, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parametersTextField)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(browseButton)
                    .addComponent(jCheckBox1))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(parametersTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(locationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton))
                .addContainerGap(52, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
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
    }//GEN-LAST:event_browseButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField locationField;
    private javax.swing.JTextField parametersTextField;
    // End of variables declaration//GEN-END:variables
}
