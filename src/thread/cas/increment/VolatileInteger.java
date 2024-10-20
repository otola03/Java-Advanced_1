package thread.cas.increment;

public class VolatileInteger implements IncrementInteger {
    volatile private int value; // shared resource
    // volatile keyword makes thread use main memory (instaed of cache memory)
    // => problem not solved (not about main or cache)
    
    @Override
    public void increment() {
        value++;
    }

    @Override
    public int get() {
        return value;
    }
}
