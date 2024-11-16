package thread.executor;

import static util.MyLogger.*;
import static util.ThreadUtils.*;
import static thread.executor.ExecutorUtils.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorBasicMain {
    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(2, 2, 0, 
                            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        log("== Initial State ==");

        printState(es);
        es.execute(new RunnableTask("taskA"));
        es.execute(new RunnableTask("taskB"));
        es.execute(new RunnableTask("taskC"));
        es.execute(new RunnableTask("taskD"));
        log("Running Tasks");
        printState(es);

        sleep(3000);
        log("== Task Complete==");
        printState(es);

        // below java v19 : shutdown()
        es.close(); // shutdown (threads in the pool removed)
        log("== Shutdown Complete ==");
        printState(es);
    }
}
