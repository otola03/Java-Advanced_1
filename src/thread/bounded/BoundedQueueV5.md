# Dividing waiting space (스레드 대기공간)

```java
    private final Lock lock = new ReentrantLock();
    private final Condition producerCond = lock.newCondition(); 
    private final Condition consumerCond = lock.newCondition();
```


**producerCond**: producer thread waiting space

**consumerCond**: consumer thread waiting space

-> producerThread awakes consumerThread, consumerThread awakes producerThread
