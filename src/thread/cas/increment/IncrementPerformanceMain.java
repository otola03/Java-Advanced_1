package thread.cas.increment;

public class IncrementPerformanceMain {

    public static final long COUNT = 100_000_000;

    public static void main(String[] args) {
        test(new BasicInteger()); 
        test(new VolatileInteger()); 
        test(new SyncInteger()); 
        test(new MyAtomicInteger());
    }

    private static void test(IncrementInteger incrementInteger) {
        long startMs = System.currentTimeMillis();

        for(int i = 0; i < COUNT; i++) {
            incrementInteger.increment();
        }

        long endMs = System.currentTimeMillis();
        System.out.println(incrementInteger.getClass().getSimpleName() + ": ms= " + (endMs-startMs));
    }

    /*
     * BasicInteger: fastest
     * - uses CPU cache 
     * - efficient when single thread
     * 
     * VolatileInteger
     * - only uses main memory 
     * - no safe critical section -> can't use in multithread environments
     * 
     * SyncInteger
     * - synchronized methods -> safe
     * - slow
     * 
     * MyAtomicInteger
     * - almost 2x faster than SyncInteger
     */
}
