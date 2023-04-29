import global.goit.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//_____________first exercise___________
        Chronometer.startChronometer(50);

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

        String resultedString = LineNumberModifier.getModifiedNumbersLine(processList, 20);
        System.out.println(resultedString);

//        ________incorrect second exercise_______

        NumberArrayModifier numberModifier = new NumberArrayModifier(150);

        try {
            System.out.println(numberModifier.buildModifiedString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        System.out.println("end ");
//        System.exit(0);
    }
}
