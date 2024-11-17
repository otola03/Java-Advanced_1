package thread.executor.future;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExceptionMain {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        log("task submission");
        Future<Integer> future = es.submit(new ExCallable());
        sleep(1000); // hold

        try {
            log("future.get() call attempt, future.state(): " + future.state());
            Integer result = future.get();
            log("result value = " + result);
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        } catch(ExecutionException e) { // exception while doing sth inside call()
            log("e = " + e); 
            Throwable cause = e.getCause(); // refer to the class
            log("cause = " + cause);
    // 11:21:34.843 [     main] e = java.util.concurrent.ExecutionException: java.lang.IllegalStateException: ex!
    // 11:21:34.843 [     main] cause = java.lang.IllegalStateException: ex!
        }

        es.close();
    }   
    static class ExCallable implements Callable<Integer> {
        @Override
        public Integer call() {
            log("Callable run, exception occured");
            throw new IllegalStateException("ex!"); // Runtime Exception
        }
    }
}
