package thread.start.test;

import static util.MyLogger.*;

public class CounterThread extends Thread { 
    @Override
    public void run() {
        for(int i = 1; i < 6; i++) {
            try {
                Thread.sleep(1000);
                log("value: " + i);
            } catch(InterruptedException e) {
                log(e.getMessage());
            }
        }
    }
}
