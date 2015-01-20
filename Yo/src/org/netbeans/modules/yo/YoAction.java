package org.netbeans.modules.yo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import org.netbeans.api.extexecution.ExecutionDescriptor;
import org.netbeans.api.extexecution.ExecutionService;
import org.netbeans.api.extexecution.ExternalProcessBuilder;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Tools",
        id = "org.netbeans.modules.yo.YoAction"
)
@ActionRegistration(
        displayName = "#CTL_YoAction"
)
@ActionReference(path = "Menu/Tools", position = 0)
@Messages("CTL_YoAction=Yo!")
public final class YoAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        NotifyDescriptor.InputLine inputLine = new NotifyDescriptor.InputLine("Folder: ", "Yeoman");
        Object result = DialogDisplayer.getDefault().notify(inputLine);
        if (NotifyDescriptor.OK_OPTION == result) {
            String inputText = inputLine.getInputText();
//            String yoPath = inputText;
            String yoPath = "C:\\\\Users\\\\gwieleng\\\\AppData\\\\Roaming\\\\npm\\\\yo.cmd";
            ExternalProcessBuilder processBuilder = new ExternalProcessBuilder(yoPath).
                    addArgument("ko").
                    //                 addArgument("-m").
                    // addArgument(namespaceName + "/" + methodName).
                    workingDirectory(new File(inputText));
            ExecutionDescriptor descriptor = new ExecutionDescriptor().
                    frontWindow(true).
                    showProgress(true).
                    showSuspended(true).
                    inputVisible(true).
                    controllable(true);
            ExecutionService service = ExecutionService.newService(
                    processBuilder,
                    descriptor,
                    "Yeoman");
            service.run();
        }
    }

}
