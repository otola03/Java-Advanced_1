package thread.bounded;

// Buffer
public interface BoundedQueue {
    void put(String data);
    String take();
}