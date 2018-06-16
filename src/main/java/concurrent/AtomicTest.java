package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by a542901 on 15/06/2018.
 */
public class AtomicTest {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println(atomicInteger.getAndIncrement());

    }
}
