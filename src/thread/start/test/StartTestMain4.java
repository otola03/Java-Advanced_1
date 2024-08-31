package thread.start.test;
import static util.MyLogger.*;

public class StartTestMain4 {
    public static void main(String[] args) {
        Thread threadA = new Thread(new PrintWork("A", 1000), "Thread-A");
        Thread threadB = new Thread(new PrintWork("B", 500), "Thread-B");

        threadA.start();
        threadB.start();
    }

    static class PrintWork implements Runnable {
        String msg;
        int ms;
        public PrintWork(String msg, int ms) {
            this.msg = msg;
            this.ms = ms;
        }
        @Override 
        public void run() {
            for(int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(ms);
                    log(msg);
                } catch(InterruptedException e) {
                    log(e.getMessage());
                }
            }
        }
    }
}
