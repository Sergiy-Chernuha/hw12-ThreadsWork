package global.goit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NumberModifier {

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public Future<String> modified(int number) {

        return executorService.submit(() -> {
            if (number % 3 == 0 && number % 5 == 0) {
                return "fizzbuzz";
            } else if (number % 3 == 0) {
                return "fizz";
            } else if (number % 5 == 0) {
                return "buzz";
            }

            return "" + number;
        });
    }
}
