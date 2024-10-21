package thread.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class CasMainV3 {

    private static final int THREAD_COUNT = 2;

    public static void main(String[] args) throws InterruptedException{
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println("start value= " + atomicInteger.get());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                incrementAndGet(atomicInteger);
            }
        };

        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        for(Thread thread: threads) {
            thread.join();
        }

        int result = atomicInteger.get();
        System.out.println(atomicInteger.getClass().getSimpleName() + " resultValue: " + result);
    }

    private static int incrementAndGet(AtomicInteger atomicInteger) {
        int getValue;
        boolean result;
        do {
            getValue = atomicInteger.get(); // t0, t1: 0
            sleep(100); // 스레드 동시 실행을 위한 대기 (중간에 getValue가 바뀌는 것을 의도하는거)
            log("getValue= " + getValue);
            result = atomicInteger.compareAndSet(getValue, getValue+1); // CAS operation
            log("result= " + result);
        } while(!result);
        return getValue + 1;
    }
}
