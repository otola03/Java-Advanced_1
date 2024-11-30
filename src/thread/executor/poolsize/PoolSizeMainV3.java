package thread.executor.poolsize;

import static util.MyLogger.*;
import static util.ThreadUtils.*;
import static thread.executor.ExecutorUtils.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import thread.executor.RunnableTask;

public class PoolSizeMainV3 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        // new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

        log("pool created");
        printState(es);

        for(int i = 1; i <= 4; i++) {
            String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            printState(es, taskName);
        }

        sleep(3000);
        log("task completed");
        printState(es);

        // maximumPoolSize keepAliveTime: 60s
        // sleep(60_000);
        // printState(es);

        es.close();
        log("== shutdown ==");
        printState(es);
    }
}
