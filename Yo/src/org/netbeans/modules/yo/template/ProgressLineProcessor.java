package org.netbeans.modules.yo.template;

import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.extexecution.input.LineProcessor;

public class ProgressLineProcessor implements LineProcessor {
    private final ProgressHandle progress;
    private final int max;
    private final int step;
    private int value;
    public ProgressLineProcessor(ProgressHandle progress, int max, int step) {
        this.progress = progress;
        this.max = max;
        this.step = step;
    }
    @Override
    public void processLine(String line) {
        value += step;
        if (value > max) {
            value = max;
        }
        progress.progress(value);
    }
    @Override
    public void reset() {
        // noop
    }
    @Override
    public void close() {
        value = max;
        progress.progress(max);
    }
}
