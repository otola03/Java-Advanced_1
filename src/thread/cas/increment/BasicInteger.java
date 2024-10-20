package thread.cas.increment;

public class BasicInteger implements IncrementInteger {
    private int value; // shared resource

    @Override
    public void increment() {
        value++;
    }

    @Override
    public int get() {
        return value;
    }
}
