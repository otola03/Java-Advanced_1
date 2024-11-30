package thread.executor;

import static util.MyLogger.*;
import static thread.executor.ExecutorUtils.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ExecutorShutdownMain {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new RunnableTask("taskA"));
        es.execute(new RunnableTask("taskB"));
        es.execute(new RunnableTask("taskC"));
        es.execute(new RunnableTask("longTask", 100_000)); // 100s

        printState(es);

        log("== shutdown start ==");
        shutdownAndAwaitTermination(es);
        log("== shutdown complete ==");

        printState(es);
    }

    private static void shutdownAndAwaitTermination(ExecutorService es) {
        es.shutdown(); // non-blocking method, reject new tasks, complete all tasks (current and the ones in queue)
        try {
            // wait 10sec until tasks in queue are completed
            if(!es.awaitTermination(10, TimeUnit.SECONDS)) { // task completion failure (if(!false))
                log("service termination failed -> forcing termination");
                es.shutdownNow(); 
                // wait until task termination 
                if(!es.awaitTermination(10, TimeUnit.SECONDS)) { // failed again
                    log("service termination failed");
                }
            }
        } catch (InterruptedException e) {
            // awaitTermiantion() -> tasks in work interrupted
            es.shutdownNow();
        }
    }
}

