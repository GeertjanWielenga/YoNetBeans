package org.netbeans.modules.yo.wizard;

import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import org.netbeans.modules.yo.utils.ShortcutEnterPanel;
import org.netbeans.modules.yo.utils.WizardUtils;

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
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(YoConfigurationVisualPanel.class, "YoConfigurationVisualPanel.jLabel3.text")); // NOI18N

        parametersTextField.setText(org.openide.util.NbBundle.getMessage(YoConfigurationVisualPanel.class, "YoConfigurationVisualPanel.parametersTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(YoConfigurationVisualPanel.class, "YoConfigurationVisualPanel.jLabel4.text")); // NOI18N

        jTextField1.setText(org.openide.util.NbBundle.getMessage(YoConfigurationVisualPanel.class, "YoConfigurationVisualPanel.jTextField1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(YoConfigurationVisualPanel.class, "YoConfigurationVisualPanel.jButton1.text")); // NOI18N

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
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parametersTextField)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
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
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(52, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField parametersTextField;
    // End of variables declaration//GEN-END:variables
}
