package thread.executor.poolsize;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

import thread.executor.ExecutorUtils;
import thread.executor.RunnableTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

import static util.MyLogger.*;
import static util.ThreadUtils.*;


public class PoolSizeMainV1 {
    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ExecutorService es = new ThreadPoolExecutor(2, 4, 3000, TimeUnit.MILLISECONDS, workQueue);

        ExecutorUtils.printState(es);

        es.execute(new RunnableTask("task1"));
        ExecutorUtils.printState(es);

        es.execute(new RunnableTask("task2"));
        ExecutorUtils.printState(es);

        es.execute(new RunnableTask("task3"));
        ExecutorUtils.printState(es);

        es.execute(new RunnableTask("task4"));
        ExecutorUtils.printState(es);

        es.execute(new RunnableTask("task5"));
        ExecutorUtils.printState(es);

        es.execute(new RunnableTask("task6"));
        ExecutorUtils.printState(es);

        // thread max-4, queue capacity-2
        try {
            es.execute(new RunnableTask("task2"));
            ExecutorUtils.printState(es);
        } catch(RejectedExecutionException e) {
            log("task7 rejected exception: " + e);
        }

        sleep(3000);
        log("== task completion ==");
        ExecutorUtils.printState(es);

        sleep(3000);
        log("== maximumPoolSize timout");
        ExecutorUtils.printState(es);

        es.close();
        log("== ExecutorService shutdown ==");
        ExecutorUtils.printState(es);
    }
}
