package global.goit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;


public class NumberArrayModifier {
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);
    int endNumber;
    List<Future> resultThreads = new CopyOnWriteArrayList<>();
    List<String> resultList = new ArrayList<>() ;

    public NumberArrayModifier(int endNumber) {
        this.endNumber = endNumber;
    }

    public String buildModifiedString() throws Exception {
        for (int i = 1; i <= endNumber; i++) {
            resultThreads.add(executorService.submit(new NumberModifier(i)));
        }
        for (Future future : resultThreads) {
            resultList.add(String.valueOf(future.get()));
        }

        return resultList.stream().collect(Collectors.joining(","));
    }


}
