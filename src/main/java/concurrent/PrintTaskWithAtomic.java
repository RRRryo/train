package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 6/16/2018.
 */
public class PrintTaskWithAtomic implements Callable{
    private final AtomicState stateForPrint;
    private String letter;
    private Integer num;

    public PrintTaskWithAtomic(String letter, AtomicState stateForPrint) {
        this.stateForPrint = stateForPrint;
        this.letter = letter;
        this.num = EnumLetterNumber.valueOf(letter).getValue();

    }

    public Object call() throws Exception {

        stateForPrint.print(letter,num);



        return null;
    }

    public static void main(String[] args) {

        AtomicState stateForPrint = new AtomicState();
        Callable taskA = new PrintTaskWithAtomic("A",stateForPrint);
        Callable taskB = new PrintTaskWithAtomic("B",stateForPrint);
        Callable taskC = new PrintTaskWithAtomic("C",stateForPrint);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Callable<Object>> l = new ArrayList<>();
        l.add(taskA);
        l.add(taskB);
        l.add(taskC);
        try {
            executorService.invokeAll(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        executorService.shutdown();
    }
}
