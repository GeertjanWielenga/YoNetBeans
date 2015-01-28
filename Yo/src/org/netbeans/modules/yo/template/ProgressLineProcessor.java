package org.netbeans.modules.yo.template;

import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.extexecution.input.LineProcessor;
import org.openide.awt.StatusDisplayer;

public class ProgressLineProcessor implements LineProcessor {
    private final Process process;

    private final ProgressHandle progress;

    private final int max;

    private final int step;

    private int value;

    public ProgressLineProcessor(Process process, ProgressHandle progress, int max, int step) {
        this.process = process;
        this.progress = progress;
        this.max = max;
        this.step = step;
    }

    public void processLine(String line) {
        value += step;
        if (value > max) {
            value = max;
            process.destroyForcibly();
            progress.finish();
            StatusDisplayer.getDefault().setStatusText("Completing the process...");
        }
        
        progress.progress(value);
    }

    public void reset() {
        // noop
    }

    public void close() {
        value = max;
        progress.progress(max);
    }
}
