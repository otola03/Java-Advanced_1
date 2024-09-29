# BoundedQueueV2

## producerFirst

```
05:56:09.291 [     main] producer1: TERMINATED

05:56:09.292 [     main] producer2: TERMINATED

05:56:09.292 [     main] producer3: TIMED_WAITING

05:56:09.293 [     main] consumer1: BLOCKED

05:56:09.295 [     main] consumer2: BLOCKED

05:56:09.297 [     main] consumer3: BLOCKED
```
**producer3 still has the lock, consumer thread cannot access critical section (synchronized part)**

- for p3 to unlock -> c1 has to consume
- for c1 to consume -> p3 has to unlock

=> infinite waiting (log)

---

## consumerFirst

``` 
06:00:28.493 [     main] consumer1: TIMED_WAITING

06:00:28.494 [     main] consumer2: BLOCKED

06:00:28.494 [     main] consumer3: BLOCKED

06:00:28.503 [     main] producer1: BLOCKED

06:00:28.504 [     main] producer2: BLOCKED

06:00:28.509 [     main] producer3: BLOCKED
```
**consumer1 has the lock, consumer2(3) cannot access critical section (synchronized part)**

=> infinite waiting (log)

---

### yield **lock** to other threads while ```TIMED_WAITING```

Object.wait(), Object.notify() 