package thread.cas.increment;

import static util.ThreadUtils.*;
import static util.MyLogger.*;

import java.util.ArrayList;
import java.util.List;

public class IncrementThreadMain {

    public static final int THREAD_COUNT = 1000;

    public static void main(String[] args) throws InterruptedException {
        test(new BasicInteger()); // not getting expected result: 1000
        test(new VolatileInteger()); // not getting expected result: 1000
        test(new SyncInteger()); // gets 1000
    }

    private static void test(IncrementInteger incrementInteger) throws InterruptedException {
        Runnable runnable =  new Runnable() {
            @Override
            public void run() {
                sleep(30); // to slow down
                incrementInteger.increment();
            }
        };
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        for(Thread thread: threads) {
            thread.join(); // The join() method is a way to make the current thread 
                        // (the one executing this code) wait for the specified thread to finish its execution before continuing.
        }

        int result = incrementInteger.get();
        System.out.println(incrementInteger.getClass().getSimpleName() + " result:  " + result);
    }
}
