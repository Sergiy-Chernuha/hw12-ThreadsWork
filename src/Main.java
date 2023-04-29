import global.goit.Chronometer;
import global.goit.NumProcessor;
import global.goit.NumberArrayModifier;
import global.goit.ThreadProcess;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
////_____________first exercise___________
//        Chronometer.startChronometer(50);

//        ________second exercise_______
        ThreadProcess fizzProcessor = new ThreadProcess((num) -> {
            if (num % 3 == 0) {
                return "fizz";
            }

            return "";
        });
        ThreadProcess buzzProcessor = new ThreadProcess((num) -> {
            if (num % 5 == 0) {
                return "buzz";
            }

            return "";
        });
        ThreadProcess fizzBuzzProcessor = new ThreadProcess((num) -> {
            if (num % 5 == 0 && num % 3 == 0) {
                return "fizzbuzz";
            }

            return "";
        });
        ThreadProcess defaultProcessor = new ThreadProcess((num) -> {
            if (num % 5 != 0 && num % 3 != 0) {
                return "" + num;
            }

            return "";
        });
        List<ThreadProcess> processList = new ArrayList<>();
        processList.add(fizzProcessor);
        processList.add(buzzProcessor);
        processList.add(fizzBuzzProcessor);
        processList.add(defaultProcessor);

        for (ThreadProcess thread : processList) {
            thread.start();
        }

        for (int i = 1; i <= 100; i++) {
            for (ThreadProcess thread : processList) {
                thread.process(i);
            }

            while (true) {
                int processCount = 0;

                for (ThreadProcess thread : processList) {
                    if (thread.getIsProcessDone()) {
                        processCount++;
                    }
                }

                if (processCount == processList.size()) {
                    break;
                }
            }
        }
        System.exit(0);

//        ________incorrect second exercise_______
//
//        NumberArrayModifier numberModifier= new NumberArrayModifier(150);
//
//        System.out.println(numberModifier.buildModifiedString());
//        System.out.println("end ");
//        System.out.println(Thread.activeCount());
//        System.exit(0);
    }
}
