package global.goit;

public class Chronometer {
    private static volatile int i = 0;

    public static void startChronometer(int maxValue) {

        Thread firstThread = new Thread(() -> {
            try {
                for (i = 1; i <= maxValue; i++) {
                    Thread.sleep(1000);
                    System.out.println( i + " seconds have passed");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread secondThread = new Thread(() -> {
            while (maxValue != i) {

                if (i % 5 == 0) {
                    System.out.println("Минуло 5 секунд");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        firstThread.start();
        secondThread.start();
    }
}
