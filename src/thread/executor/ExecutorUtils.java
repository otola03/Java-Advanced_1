package thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static util.MyLogger.*;

public abstract class ExecutorUtils {

    public static void printState(ExecutorService executorService) { // casting
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            int pool = poolExecutor.getPoolSize();
            int active = poolExecutor.getActiveCount(); // num of threads running tasks
            int queuedTasks = poolExecutor.getQueue().size(); // num of tasks
            long completedTask = poolExecutor.getCompletedTaskCount();  
            log("pool= " + pool + ", active= " + active + ", queuedTasks= " 
                + queuedTasks + ", completedTask= " + completedTask);
        } else {
            log(executorService);
        }
    }
}