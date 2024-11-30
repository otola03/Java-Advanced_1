package thread.executor.poolsize;

import static util.MyLogger.*;
import static util.ThreadUtils.*;
import static thread.executor.ExecutorUtils.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import thread.executor.RunnableTask;

public class PoolSizeMainV2 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        // ExecutorService es = new ThreadPoolExecutor(2, nThreads, 0, 
        //                                             TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        log("pool created");
        printState(es);

        for(int i = 1; i <= 6; i++) {
            String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            printState(es, taskName);
        }
        es.close();
        log("== shutdown ==");
    }
}
