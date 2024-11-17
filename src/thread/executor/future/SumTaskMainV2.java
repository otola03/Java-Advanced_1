package thread.executor.future;

import static util.MyLogger.log;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumTaskMainV2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        
        Future<Integer> future1 = es.submit(new SumTask(1, 50));
        Future<Integer> future2 = es.submit(new SumTask(51, 100));

        Integer res1 = future1.get();
        Integer res2 = future2.get();

        log("res1 = " + res1);
        log("res2 = " + res2);
        log("sum = " + (res1 + res2));

        log("END");
        es.close();
    }


    static class SumTask implements Callable<Integer> {
        int startValue;
        int endValue;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public Integer call() throws Exception {
            log("task start");
            Thread.sleep(2000); // can throw away Checked Exception
            int sum = 0;
            for(int i = startValue; i <= endValue; i++) {
               sum += i;
            } 
            log("task complete, sum = " + sum);
            return sum;
        }
    }
}
