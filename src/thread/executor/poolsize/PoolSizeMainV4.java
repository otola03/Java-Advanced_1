package thread.executor.poolsize;

import static util.MyLogger.*;
import static thread.executor.ExecutorUtils.*;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import thread.executor.RunnableTask;

public class PoolSizeMainV4 {

    //static final int TASK_SIZE = 1100; // 1. normal  
    //static final int TASK_SIZE = 1200; // 2. emergency (queue is full => extra threads created)
    static final int TASK_SIZE = 1201; // 3. rejection
    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(100, 200, 60, 
                                                    TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));
        printState(es);

        long startMs = System.currentTimeMillis();

        for(int i = 1; i <= TASK_SIZE; i++) {
            String taskName = "task" + i;
            try {
                es.execute(new RunnableTask(taskName));
                printState(es);
            } catch(RejectedExecutionException e) {
                log(taskName + " -> " + e);
            }
        }

        es.close();
        long endMs = System.currentTimeMillis();
        log("time: " + (endMs-startMs));
        printState(es);
    }
}
