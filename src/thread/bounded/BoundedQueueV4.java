package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.*;

public class BoundedQueueV4 implements BoundedQueue {

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition(); // new waiting set!

    // shared resource
    private final Queue<String> queue = new ArrayDeque<>();
    private final int max; // "Bounded" queue

    public BoundedQueueV4(int max) {
        this.max = max;
    }
    // multiple threads will use these methods > synchronized 
    // safe critical section!

    // t1 right before putting data
    // t2 puts data
    // might exceed max size
    
    @Override
    public void put(String data) {
        lock.lock();
        try {
            while(queue.size() == max) {
                log("[put] Queue is full, producer wait");
                try {
                    condition.await();
                    log("[put] producer awake");
                } catch(InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.offer(data);
            log("[put] producer data saved, notify() called");
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String take() {
        lock.lock();
        try{
            while(queue.isEmpty()) {
                log("[take] Queue empty, consumer wait");
                try {
                    condition.await();
                    log("[take] consumer awake");
                } catch(InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            String data = queue.poll();
            log("[take] consumer data taken, notify() called");
            condition.signal();
            return data;
        } finally {
            lock.unlock();
        }
    }
    
    @Override
    public String toString() {
        return queue.toString();
    }
}
