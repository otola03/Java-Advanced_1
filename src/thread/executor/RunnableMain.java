package thread.executor;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

import java.util.Random;


// Runnable has no "return value"
public class RunnableMain {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable task = new MyRunnable();
        Thread thread = new Thread(task, "Thread-1");
        thread.start();
        thread.join(); // wait for Thread-1 completion (for the code below)
        int result = task.value;
        log("result= " + result);
    }

    static class MyRunnable implements Runnable {
        int value;

        @Override
        public void run() {
            log("Runnable start");
            sleep(2000); // time for the task
            value = new Random().nextInt(10); // 0~9
            log("created value= " + value);
            log("Runnable complete");
        }
    }
}
