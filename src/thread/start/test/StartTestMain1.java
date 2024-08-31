package thread.start.test;
import static util.MyLogger.*;

public class StartTestMain1 {
    public static void main(String[] args) {
        log("main() start");
        CounterThread counterThread = new CounterThread();
        counterThread.start();
        log("main() end");
    }
}
