package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 6/16/2018.
 */
public class PrintTaskByJoin implements Callable<Boolean>{

    private char letter;

    public PrintTaskByJoin(char c) {
        this.letter = c;
    }

    @Override
    public Boolean call() throws Exception {
        System.out.println(letter);
        return null;
    }

    public static void main(String[] args) {
        PrintTaskByJoin printTaskA = new PrintTaskByJoin('A');
        PrintTaskByJoin printTaskB = new PrintTaskByJoin('B');
        PrintTaskByJoin printTaskC = new PrintTaskByJoin('C');

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i=0; i< 10 ;i++) {
            executorService.submit(printTaskA);
            executorService.shutdown();
            executorService.submit(printTaskB);
            executorService.shutdown();
            executorService.submit(printTaskB);

        }





    }
}
