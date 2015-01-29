package org.netbeans.modules.yo.template2;

import java.io.File;
import org.netbeans.api.extexecution.ExecutionDescriptor;
import org.netbeans.api.extexecution.ExecutionService;
import org.netbeans.api.extexecution.ExternalProcessBuilder;

public class NodeRunner {

    public static void installYeomanGenerator(String name) {
        File userdir = new File(System.getProperty("netbeans.user"));
        ExternalProcessBuilder processBuilder
                = new ExternalProcessBuilder("C:\\Program Files\\nodejs\\npm.cmd").
                addArgument("install").
                addArgument("-g").
                addArgument(name).
                workingDirectory(userdir);
        ExecutionDescriptor descriptor = new ExecutionDescriptor().frontWindow(true);
        ExecutionService service = ExecutionService.newService(
                processBuilder,
                descriptor,
                "Yeoman");
        service.run();
    }

}
