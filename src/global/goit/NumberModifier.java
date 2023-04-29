package global.goit;

import java.util.concurrent.Callable;

public class NumberModifier implements Callable {
    private final int number;

    public NumberModifier(int number) {
        this.number = number;
    }

    @Override
    public synchronized String call() {
        if (number % 3 == 0 && number % 5 == 0) {
            return "fizzbuzz";
        } else if (number % 3 == 0) {
            return "fizz";
        } else if (number % 5 == 0) {
            return "buzz";
        }

        return "" + number;
    }
}