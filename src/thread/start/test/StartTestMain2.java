package thread.start.test;

public class StartTestMain2 {
    public static void main(String[] args) {
        Runnable runnable = new CounterRunnable();
        Thread counter = new Thread(runnable, "counter");
        counter.start();
    }    
}
