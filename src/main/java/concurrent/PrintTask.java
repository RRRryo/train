package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 6/13/2018.
 */
public class PrintTask implements Callable {

    private final StateForPrint stateForPrint;
    private String letter;
    private Integer num;

    public PrintTask(String letter, StateForPrint stateForPrint) {
        this.stateForPrint = stateForPrint;
        this.letter = letter;
        this.num = EnumLetterNumber.valueOf(letter).getValue();

    }

    public Object call() throws Exception {

        int i = 0;

        while (i < 10) {
            synchronized (stateForPrint) {
                if (stateForPrint.getState() % 3 == num) {
                    System.out.print(letter);
                    stateForPrint.setState(stateForPrint.getState() + 1);
                    i++;
                }

            }

        }

        return null;
    }

    public static void main(String[] args) {

        StateForPrint stateForPrint = new StateForPrint();
        Callable taskA = new PrintTask("A",stateForPrint);
        Callable taskB = new PrintTask("B",stateForPrint);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Callable taskC = new PrintTask("C",stateForPrint);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(taskA);
        executorService.submit(taskB);
        executorService.submit(taskC);


        executorService.shutdown();
    }
}
