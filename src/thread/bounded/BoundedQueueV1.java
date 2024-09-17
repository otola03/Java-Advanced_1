package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static util.MyLogger.*;

public class BoundedQueueV1 implements BoundedQueue {
    // shared resource
    private final Queue<String> queue = new ArrayDeque<>();
    private final int max; // "Bounded" queue

    public BoundedQueueV1(int max) {
        this.max = max;
    }
    // multiple threads will use these methods > synchronized 
    // safe critical section!

    // t1 right before putting data
    // t2 puts data
    // might exceed max size
    
    @Override
    public synchronized void put(String data) {
        if(queue.size() == max) {
            log("[put] Queue is full, discard: " + data);
            return;
        }
        queue.offer(data);
    }

    @Override
    public synchronized String take() {
        if(queue.isEmpty()) {
            return null;
        }

        return queue.poll();
    }
    
    @Override
    public String toString() {
        return queue.toString();
    }
}
