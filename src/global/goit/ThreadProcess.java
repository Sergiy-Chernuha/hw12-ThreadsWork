package global.goit;

import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadProcess extends Thread {
    private final NumProcessor numProcessor;
    private int number;
    private final AtomicBoolean isProcessDone = new AtomicBoolean(true);

    public ThreadProcess(NumProcessor numProcessor) {
             this.numProcessor = numProcessor;
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
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            System.out.println(number+",sdhg,jhs"+isProcessDone.get());
            if (isProcessDone.get()) {
                continue;
            }

            numProcessor.check(number);
            isProcessDone.set(true);
        }
    }


}
