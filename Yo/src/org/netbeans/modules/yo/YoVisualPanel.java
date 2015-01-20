package org.netbeans.modules.yo;

import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import org.netbeans.modules.yo.utils.ShortcutEnterPanel;
import org.netbeans.modules.yo.utils.WizardUtils;

public final class YoVisualPanel extends JPanel {

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

    public YoVisualPanel() {
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

    public String getDisplayNameTextField() {
        return displayNameTextField.getText();
    }

    public String getKeyStrokes() {
        return WizardUtils.keyStrokesToLogicalString(keyStrokes);
    }
    
    public String getParameters() {
        return parametersTextField.getText();
    }

    @Override
    public String getName() {
        return "Yeoman Configuration";
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        parametersTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        displayNameTextField = new javax.swing.JTextField();
        shortcutTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        createKeyboardShortcut = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(YoVisualPanel.class, "YoVisualPanel.jLabel3.text")); // NOI18N

        parametersTextField.setText(org.openide.util.NbBundle.getMessage(YoVisualPanel.class, "YoVisualPanel.parametersTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(YoVisualPanel.class, "YoVisualPanel.jLabel4.text")); // NOI18N

        jTextField1.setText(org.openide.util.NbBundle.getMessage(YoVisualPanel.class, "YoVisualPanel.jTextField1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(YoVisualPanel.class, "YoVisualPanel.jButton1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(YoVisualPanel.class, "YoVisualPanel.jLabel1.text")); // NOI18N

        displayNameTextField.setText(org.openide.util.NbBundle.getMessage(YoVisualPanel.class, "YoVisualPanel.displayNameTextField.text")); // NOI18N

        shortcutTextField.setEditable(false);
        shortcutTextField.setText(org.openide.util.NbBundle.getMessage(YoVisualPanel.class, "YoVisualPanel.shortcutTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(YoVisualPanel.class, "YoVisualPanel.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(createKeyboardShortcut, org.openide.util.NbBundle.getMessage(YoVisualPanel.class, "YoVisualPanel.createKeyboardShortcut.text")); // NOI18N
        createKeyboardShortcut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createKeyboardShortcutActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBox1, org.openide.util.NbBundle.getMessage(YoVisualPanel.class, "YoVisualPanel.jCheckBox1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(YoVisualPanel.class, "YoVisualPanel.jLabel5.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(displayNameTextField)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(shortcutTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createKeyboardShortcut)
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(parametersTextField)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jCheckBox1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(parametersTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(displayNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(shortcutTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(createKeyboardShortcut)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createKeyboardShortcutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createKeyboardShortcutActionPerformed
        keyStrokes = ShortcutEnterPanel.showDialog();
        if (keyStrokes != null && keyStrokes.length > 0) {
            String newShortcut = WizardUtils.keyStrokesToString(keyStrokes);
            shortcutTextField.setText(newShortcut);
        }
    }//GEN-LAST:event_createKeyboardShortcutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createKeyboardShortcut;
    private javax.swing.JTextField displayNameTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField parametersTextField;
    private javax.swing.JTextField shortcutTextField;
    // End of variables declaration//GEN-END:variables
}
