package thread.bounded;

import static util.MyLogger.*;

public class ConsumerTask implements Runnable {

    private BoundedQueue queue;
    
    public ConsumerTask(BoundedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        log("[Consume attempt]     ? <- " + queue);
        String data = queue.take();
        log("[Consume success]     " + data + " <- " + queue);
    }
}
