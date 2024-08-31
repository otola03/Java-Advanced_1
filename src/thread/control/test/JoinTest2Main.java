package thread.control.test;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class JoinTest2Main {
    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(new MyTask(), "t1");
        Thread t2 = new Thread(new MyTask(), "t2");
        Thread t3 = new Thread(new MyTask(), "t3");

        t1.start();
        t2.start();
        t3.start();
        t3.join();

        System.out.println("All Threads Completed");
    }    

    static class MyTask implements Runnable {
        @Override
        public void run() {
            for(int i = 1; i <= 3; i++) {
                log(i);
                sleep(1000);
            }
        }
    }   
}
