package currency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by a542901 on 14/06/2018.
 */
public class PrintTaskWithLock implements Callable{

    private StateForPrint stateForPrint;
    private String letter;
    private Integer num;
    private Lock lock = new ReentrantLock();

    public PrintTaskWithLock(String letter, StateForPrint stateForPrint) {
        this.stateForPrint = stateForPrint;
        this.letter = letter;
        this.num = EnumLetterNumber.valueOf(letter).getValue();

    }

    public Object call() throws Exception {

        int i = 0;

        while (i < 20) {
            lock.lock();
            try {
                if (stateForPrint.getState() % 3 == num) {
                    System.out.print(letter);
                    stateForPrint.setState(stateForPrint.getState() + 1);
                    i++;
                }
            } finally {
                lock.unlock();
            }
        }

        return null;
    }

    public static void main(String[] args) {

        StateForPrint stateForPrint = new StateForPrint();
        Callable taskA = new PrintTaskWithLock("A",stateForPrint);
        Callable taskB = new PrintTaskWithLock("B",stateForPrint);
        Callable taskC = new PrintTaskWithLock("C",stateForPrint);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(taskA);
        executorService.submit(taskB);
        executorService.submit(taskC);


        executorService.shutdown();
    }
}
