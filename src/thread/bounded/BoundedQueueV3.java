package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class BoundedQueueV3 implements BoundedQueue {
    // shared resource
    private final Queue<String> queue = new ArrayDeque<>();
    private final int max; // "Bounded" queue

    public BoundedQueueV3(int max) {
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
            log("[put] Queue is full, producer wait");
            try {
                wait(); // RUNNABLE -> WAITING, returns LOCK
                log("[put] producer awake");
            } catch(InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.offer(data);
        log("[put] producer data saved, notify() called");
        notify(); // waiting thread, WAIT -> BLOCKED
    }

    @Override
    public synchronized String take() {
        while(queue.isEmpty()) {
            log("[take] Queue empty, consumer wait");
            try {
                wait(); // RUNNABLE -> WAITING, returns LOCK
                log("[take] consumer awake");
            } catch(InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String data = queue.poll();
        log("[take] consumer data taken, notify() called");
        notify(); // waiting thread, WAIT -> BLOCKED
        return data;
    }
    
    @Override
    public String toString() {
        return queue.toString();
    }
}
