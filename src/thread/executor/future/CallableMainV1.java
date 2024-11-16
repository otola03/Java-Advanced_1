package thread.executor.future;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableMainV1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // ExecutorService es = new ThreadPoolExecutor(2, 2, 0, 
        //                                             TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        // Simple way...
        ExecutorService es = Executors.newFixedThreadPool(1); // corePoolSize, maximumPoolSize = 1
        Future<Integer> future = es.submit(new MyCallable());
        Integer result = future.get();
        // Integer result = es.submit(new Callable()).get();
        log("result value = " + result);
        es.close();

    }

    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() {
            log("Callable start");
            sleep(2000);
            int value = new Random().nextInt(10);
            log("create value = " + value);
            log("Callable complete");
            return value;
        }
    }
}
