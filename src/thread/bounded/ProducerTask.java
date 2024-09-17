package thread.bounded;

import static util.MyLogger.*;

public class ProducerTask implements Runnable {

    private BoundedQueue queue;
    private String request;

    public ProducerTask(BoundedQueue queue, String request) {
        this.queue = queue;
        this.request = request;
    }

    @Override
    public void run() {
        log("[Produce attempt]: " + request + " -> " + queue);
        queue.put(request);
        log("[Produce success]: " + request + " -> " + queue);
    }
}
