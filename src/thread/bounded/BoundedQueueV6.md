# BlockingQueue
- block put() when queue is full
- block take() when queue is empty

``` java.util.concurrent.BlockingQueue``` interface

|                 | Throws exception | Special value | Blocks    | Times out             |
|-----------------|------------------|---------------|-----------|-----------------------|
| **Insert**       | add(e)           | offer(e)      | put(e)    | offer(e, time, unit)   |
| **Remove**       | remove()         | poll()        | take()    | poll(time, unit)       |
| **Examine**      | element()        | peek()        | not applicable | not applicable    |



```ArrayBlockingQueue``` and ```LinkedBlockingQueue```

### ArrayBlockingQueue
based on an Array, limited buffer

### LinkedBlockingQueue
based on a linkedlist, limited or unlimited buffer



basic function is the same as *BoundedQueueV5*