package thread.executor.future;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCancelMain {
    private static boolean mayInterruptIfRunning = false; 
    //private static boolean mayInterruptIfRunning = true; 

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<String> future = es.submit(new MyTask());
        log("future state: " + future.state());

        // cancel after some time
        sleep(3000);

        // cancel()
        log("future.cancel(" + mayInterruptIfRunning + ") called");
        boolean cancelResult = future.cancel(mayInterruptIfRunning);
        log("cancel(" + mayInterruptIfRunning + ") result: " + cancelResult);


        // check result
        try {
            log("Future result: " + future.get());
        } catch(CancellationException e) {
            log("Future is already cancelled");
        } catch(InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        es.close();
    }

    static class MyTask implements Callable<String> {
        @Override
        public String call() {
            try {
                for(int i = 0; i < 10; i++) {
                    log("Computing " + i);
                    Thread.sleep(1000);
                } 
            } catch(InterruptedException e) {
                log("Interruption occured");
                return "Interrupted";
            }
            return "Completed";
        }
    }
}
