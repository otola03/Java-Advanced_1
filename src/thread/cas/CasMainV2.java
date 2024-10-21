package thread.cas;

import java.util.concurrent.atomic.AtomicInteger;
import static util.MyLogger.*;

public class CasMainV2 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("start value= " + atomicInteger);

        boolean result1 = incrementAndGet(atomicInteger);
        System.out.println("result1= " + result1 + ", value= " + atomicInteger.get());

        boolean result2 = incrementAndGet(atomicInteger);
        System.out.println("result2= " + result2 + ", value= " + atomicInteger.get());
    }

    private static boolean incrementAndGet(AtomicInteger atomicInteger) {
        int getValue;
        boolean result;
        do {
            getValue = atomicInteger.get();
            log("getValue= " + getValue);
            result = atomicInteger.compareAndSet(getValue, getValue+1);
            log("result= " + result);
        } while(!result);
        return result;
    }
}
