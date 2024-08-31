package thread.control;

public class CheckedExceptionMain {
    public static void main(String[] args) {
        
    }
    static class CheckedRunnable implements Runnable {
        @Override
        public void run() /* throws InterruptedException */ {
           // throw new InterruptedException();
        }
    }
}
/*
   public interface Runnable {
    void run();
   }
*/

