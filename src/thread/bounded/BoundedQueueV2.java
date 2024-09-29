package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class BoundedQueueV2 implements BoundedQueue {
    // shared resource
    private final Queue<String> queue = new ArrayDeque<>();
    private final int max; // "Bounded" queue

    public BoundedQueueV2(int max) {
        this.max = max;
    }
    // multiple threads will use these methods > synchronized 
    // safe critical section!

    // t1 right before putting data
    // t2 puts data
    // might exceed max size
    
    @Override
    public synchronized void put(String data) {
        while(queue.size() == max) {
            log("[put] Queue is full, producer sleep");
            sleep(1000);
            return;
        }
        queue.offer(data);
    }

    @Override
    public synchronized String take() {
        while(queue.isEmpty()) {
            log("[take] Queue empty, consumer sleep");
            sleep(1000);
        }
        return queue.poll();
    }
    
    @Override
    public String toString() {
        return queue.toString();
    }
}
