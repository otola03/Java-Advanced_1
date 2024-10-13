package thread.bounded;

import static util.MyLogger.log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

// 즉시 반환
public class BoundedQueueV6_3 implements BoundedQueue {

    private BlockingQueue<String> queue;

    public BoundedQueueV6_3(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }

    @Override 
    public void put(String data) {
        // 대기 시간 설정
        try { 
            boolean result = queue.offer(data, 1, TimeUnit.NANOSECONDS);
            log("Data save attempt: " + result);
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override 
    public String take() {
        // 대기 시간 설정
        try { 
            return queue.poll(2, TimeUnit.SECONDS);
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
