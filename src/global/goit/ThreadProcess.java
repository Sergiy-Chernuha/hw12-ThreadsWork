package global.goit;

import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadProcess extends Thread {
    private final NumProcessor numProcessor;
    private final AtomicBoolean isProcessDone = new AtomicBoolean(true);
    private int number;
    private String result = "";

    public ThreadProcess(NumProcessor numProcessor) {
        this.numProcessor = numProcessor;
    }

    public String getResult() {
        return result;
    }

    public boolean getIsProcessDone() {
        return isProcessDone.get();
    }

    public void process(int i) {
        this.number = i;
        isProcessDone.set(false);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (isProcessDone.get()) {
                continue;
            }

            result = numProcessor.check(number);
            isProcessDone.set(true);
        }
    }
}
