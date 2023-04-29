package global.goit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class NumberArrayModifier {
    int endNumber;
    NumberModifier modifier = new NumberModifier();
    List<Future<String>> resultThreads = new ArrayList<>();
    List<String> resultList = new ArrayList<>();

    public NumberArrayModifier(int endNumber) {
        this.endNumber = endNumber;
    }

    public String buildModifiedString() throws Exception {
        for (int i = 1; i <= endNumber; i++) {
            resultThreads.add((modifier.modified(i)));
        }
        while (resultThreads.stream().filter(Future::isDone).count() != endNumber) {
            Thread.sleep(100);
        }
        for (Future<String> future : resultThreads) {
            resultList.add(future.get());
        }

        return String.join(",", resultList);
    }
}
