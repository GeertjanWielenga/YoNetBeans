package org.netbeans.modules.yo;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.netbeans.api.extexecution.ExecutionDescriptor;
import org.netbeans.api.extexecution.ExecutionService;
import org.netbeans.api.extexecution.ExternalProcessBuilder;
import org.netbeans.modules.yo.wizard.YoConfigurationVisualPanel;
import org.openide.util.NbPreferences;

public class YoActionFactory {

    public static Action createGenericAction(Map<String, ?> attributes) {
        return new GenericAction(
                (String) attributes.get("displayName"),
                (String) attributes.get("createdAt"),
                (String) attributes.get("configuration")
        );
    }

    private static class GenericAction extends AbstractAction {

        private final String createdAt;
        private final String configuration;

        public GenericAction(String displayName, String createdAt, String configuration) {
            super(displayName);
            this.createdAt = createdAt;
            this.configuration = configuration;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
//            JOptionPane.showMessageDialog(
//                    null, 
//                    configuration,
//                    "Created at: " +createdAt, 
//                    JOptionPane.INFORMATION_MESSAGE);
//            String inputText = inputLine.getInputText();
//            String yoPath = inputText;
            String yoPath = "C:\\\\Users\\\\gwieleng\\\\AppData\\\\Roaming\\\\npm\\\\yo.cmd";
            String userDir = System.getProperty("user.home");
            String yoProjectFolder = NbPreferences.forModule(YoConfigurationVisualPanel.class).get("yoProjectFolder", userDir);
            ExternalProcessBuilder processBuilder = new ExternalProcessBuilder(yoPath).
                    addArgument(configuration).
                    //                    addArgument("programme-grid").
                    // addArgument(namespaceName + "/" + methodName).
                    workingDirectory(new File(yoProjectFolder));
            ExecutionDescriptor descriptor = new ExecutionDescriptor().
                    frontWindow(true).
                    showProgress(true).
                    showSuspended(true).
                    inputVisible(true).
                    controllable(true);
            ExecutionService service = ExecutionService.newService(
                    processBuilder,
                    descriptor,
                    "Yeoman " + configuration);
            service.run();
        }
    }
}
