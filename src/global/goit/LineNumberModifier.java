package global.goit;

import java.util.ArrayList;
import java.util.List;

public class LineNumberModifier {

    public static String getModifiedNumbersLine(List<ThreadProcess> processList, int number) {
        List<String> resultList = new ArrayList<>();

        for (ThreadProcess thread : processList) {
            thread.start();
        }

        for (int i = 1; i <= number; i++) {
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
                    for (ThreadProcess thread : processList) {
                        if (!thread.getResult().isEmpty())
                            resultList.add(thread.getResult());
                    }

                    break;
                }
            }
        }
        return String.join(", ", resultList);
    }
}
