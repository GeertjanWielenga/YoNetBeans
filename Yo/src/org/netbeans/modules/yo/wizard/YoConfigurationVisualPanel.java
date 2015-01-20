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
        jLabel5 = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(YoConfigurationVisualPanel.class, "YoConfigurationVisualPanel.jLabel3.text")); // NOI18N

        parametersTextField.setText(org.openide.util.NbBundle.getMessage(YoConfigurationVisualPanel.class, "YoConfigurationVisualPanel.parametersTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(YoConfigurationVisualPanel.class, "YoConfigurationVisualPanel.jLabel5.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(parametersTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addGap(112, 112, 112))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(parametersTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(86, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField parametersTextField;
    // End of variables declaration//GEN-END:variables
}
