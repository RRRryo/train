package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 6/16/2018.
 */
public class AtomicState {
    private AtomicInteger state = new AtomicInteger(0);

    public AtomicInteger getState() {
        return state;
    }

    public void setState(AtomicInteger state) {
        this.state = state;
    }

    public void print(String letter, int num) {
        int i = 0;
        while (i < 20) {

            if (this.state.get() % 3 == num) {
                System.out.print(letter);
                this.state.incrementAndGet();
                i++;
            }
        }

    }
}
