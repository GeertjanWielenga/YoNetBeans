package org.netbeans.modules.yo.wizard;

import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import org.netbeans.modules.yo.utils.ShortcutEnterPanel;
import org.netbeans.modules.yo.utils.WizardUtils;

public final class YoGUIRegistrationVisualPanel extends JPanel {

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

    public YoGUIRegistrationVisualPanel() {
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
        String keyStrokesToLogicalString = "";
        if (keyStrokes != null) {
            keyStrokesToLogicalString = WizardUtils.keyStrokesToLogicalString(keyStrokes);
        }
        return keyStrokesToLogicalString;
    }

//    public String getParameters() {
//        return parametersTextField.getText();
//    }
    @Override
    public String getName() {
        return "GUI Registration";
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        displayNameTextField = new javax.swing.JTextField();
        shortcutTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        createKeyboardShortcut = new javax.swing.JButton();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(YoGUIRegistrationVisualPanel.class, "YoGUIRegistrationVisualPanel.jLabel1.text")); // NOI18N

        displayNameTextField.setText(org.openide.util.NbBundle.getMessage(YoGUIRegistrationVisualPanel.class, "YoGUIRegistrationVisualPanel.displayNameTextField.text")); // NOI18N

        shortcutTextField.setEditable(false);
        shortcutTextField.setText(org.openide.util.NbBundle.getMessage(YoGUIRegistrationVisualPanel.class, "YoGUIRegistrationVisualPanel.shortcutTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(YoGUIRegistrationVisualPanel.class, "YoGUIRegistrationVisualPanel.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(createKeyboardShortcut, org.openide.util.NbBundle.getMessage(YoGUIRegistrationVisualPanel.class, "YoGUIRegistrationVisualPanel.createKeyboardShortcut.text")); // NOI18N
        createKeyboardShortcut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createKeyboardShortcutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(displayNameTextField)
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(shortcutTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createKeyboardShortcut)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(displayNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(shortcutTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(createKeyboardShortcut)))
                .addContainerGap(40, Short.MAX_VALUE))
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField shortcutTextField;
    // End of variables declaration//GEN-END:variables
}
