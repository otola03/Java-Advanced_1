# `Executors` class provides some basic methods for thread pool

### 단일 풀 전략: `newSingleThreadPool()`
- core size = 1
- no limit to the BlockingQueue (`LinkedBlockingQueue`)
- used for simple test cases

### 고정 풀 전략: `newFixedThreadPool(nThreads)`
```java
new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>())
```
- core size = nThreads
- no limit to the BlockingQueue (`LinkedBlockingQueue`)
- thread # fixed -> CPU, memory usage can be easily expected -> safe, stable

#### **caution**
1. gradual user increase -> service response time increases
2. sudden user increase -> users complain about response time

- fixed # of thread -> CPU, memory usage are still stable
- user requests piled up in the queue! (queue size unlimited) 

=> spare server resource, slower service 

### 캐시 풀 전략: `newCachedThreadPool()`
```java
new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
```
- core size = 0
- no limit to the BlockingQueue (`SynchronousQueue`)
- x use basic threads, **only use extra threads** with **60sec** life
- **unlimited** extra threads
- x store tasks in queue (`SynchronousQueue`)
- all tasks don't wait => quick tasks' completion

#### `SynchronousQueue`
- implements `BlockingQueue`
- buffer size = 0 (storage = 0)
- direct transaction btw producer and consumer thread 


=> very flexible strategy (also reuses extra thread inside the pool if necessary)  
=> all tasks are handled by **extra threads**

#### **caution**
1. gradual user increase -> gradual extra thread increase -> CPU, memory usage increase naturally
2. sudden user increase -> users complain about response time
    - thread creation is very ***costly*** -> system slows down


