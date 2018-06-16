package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 6/13/2018.
 */
public class StateForPrint {

    private Integer state = 0;

    private Lock lock = new ReentrantLock();

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void print(String letter, int num) {
        int i = 0;
        while (i < 20) {
            lock.lock();
            try {
                if (this.getState() % 3 == num) {
                    System.out.print(letter);
                    this.setState(this.getState() + 1);
                    i++;
                }

            } finally {
                lock.unlock();
            }
        }

    }
}
