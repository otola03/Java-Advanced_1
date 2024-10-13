package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.*;

public class BoundedQueueV5 implements BoundedQueue {

    private final Lock lock = new ReentrantLock();
    private final Condition producerCond = lock.newCondition(); // new waiting set!
    private final Condition consumerCond = lock.newCondition(); // new waiting set!

    // shared resource
    private final Queue<String> queue = new ArrayDeque<>();
    private final int max; // "Bounded" queue

    public BoundedQueueV5(int max) {
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
                    producerCond.await();
                    log("[put] producer awake");
                } catch(InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.offer(data);
            log("[put] producer data saved, consumerCond.signal() called");
            consumerCond.signal();
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
                    consumerCond.await();
                    log("[take] consumer awake");
                } catch(InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            String data = queue.poll();
            log("[take] consumer data taken, producerCond.signal() called");
            producerCond.signal();
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
