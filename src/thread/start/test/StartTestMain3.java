package thread.start.test;
import static util.MyLogger.*;

public class StartTestMain3 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i <= 5; i++) {
                    try {
                        Thread.sleep(1000);
                        log("value: " + i);
                    } catch(InterruptedException e) {
                        log(e.getMessage());
                    }
                }
            }
        }, "counter");
        thread.start();
    }
}
