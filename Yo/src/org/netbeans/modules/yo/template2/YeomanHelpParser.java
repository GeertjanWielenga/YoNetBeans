package org.netbeans.modules.yo.template2;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.netbeans.api.extexecution.ExecutionDescriptor;
import org.netbeans.api.extexecution.ExecutionService;
import org.netbeans.api.extexecution.ExternalProcessBuilder;
import org.netbeans.api.extexecution.input.InputProcessor;
import org.netbeans.api.extexecution.input.InputProcessors;
import org.netbeans.api.extexecution.input.LineProcessor;
import org.netbeans.modules.yo.wizard.YoConfigurationVisualPanel;
import org.openide.util.NbPreferences;

public class YeomanHelpParser {

    static List<String> availableYoGenerators = new ArrayList<String>();
    static List<String> availableYoCommands = new ArrayList<String>();

    public static List<String> getAvailableYoGenerators() {
        return availableYoGenerators;
    }

    public static List<String> getAvailableYoCommands() {
        return availableYoCommands;
    }

    public static void parseYoHelp() {
        File userdir = new File(System.getProperty("netbeans.user"));
        String yo = NbPreferences.forModule(YoConfigurationVisualPanel.class).get("yoExecutableLocation", "");
        ExternalProcessBuilder processBuilder
                = new ExternalProcessBuilder(yo).
                addArgument("--help").
                workingDirectory(userdir);
        final HelpLineProcessor lineProcessor = new HelpLineProcessor();
        ExecutionDescriptor descriptor = new ExecutionDescriptor().
                outProcessorFactory(new ExecutionDescriptor.InputProcessorFactory() {
                    @Override
                    public InputProcessor newInputProcessor(InputProcessor defaultProcessor) {
                        return InputProcessors.bridge(lineProcessor);
                    }
                });
        ExecutionService service = ExecutionService.newService(
                processBuilder,
                descriptor,
                "Yeoman");
        Future<Integer> task = service.run();
        try {
            if (task.get() == 0) {
                for (String generator : lineProcessor.getGenerators()) {
                    availableYoGenerators.add(generator);
                }
                for (String command : lineProcessor.getCommands()) {
                    availableYoCommands.add(command);
                }
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException ex) {
        }
    }

    private static class HelpLineProcessor implements LineProcessor {

        private final List<String> generators = Collections.synchronizedList(new ArrayList<String>());
        private final List<String> commands = Collections.synchronizedList(new ArrayList<String>());

        @Override
        public void processLine(String line) {
            line = line.trim();
            boolean keep
                    = !(line.startsWith("Usage")
                    || line.isEmpty()
                    || line.startsWith("General")
                    || line.startsWith("-h")
                    || line.startsWith("-f")
                    || line.startsWith("Please"));
            if (keep) {
                if (line.contains(":")) {
                    commands.add(line);
                } else {
                    generators.add(line);
                }
            }
        }

        public List<String> getCommands() {
            return commands;
        }

        public List<String> getGenerators() {
            return generators;
        }

        @Override
        public void close() {
        }

        @Override
        public void reset() {
        }
    }

}
