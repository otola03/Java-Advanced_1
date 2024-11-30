## ThreadPoolExecutor(ExecutorService)
1. `BlockingQueue`: stores tasks (use `BlockingQueue` to handle Producer-Consumer problem)
2. Thread Pool: manages threads

**producer**: main thread -> stores task inside `BlockingQueue` when es.execute() called  
**consumer**: Thread inside Thread Pool


```
09:12:09.820 [     main] == Initial State ==  
09:12:09.853 [     main] pool= 0, active= 0, queuedTasks= 0, completedTask= 0  
09:12:09.856 [     main] Running Tasks  
09:12:09.859 [     main] pool= 2, active= 2, queuedTasks= 2, completedTask= 0  
09:12:09.860 [pool-1-thread-1] taskA start  
09:12:09.862 [pool-1-thread-2] taskB start  
09:12:10.863 [pool-1-thread-1] taskA finish  
09:12:10.864 [pool-1-thread-1] taskC start  
09:12:10.865 [pool-1-thread-2] taskB finish  
09:12:10.866 [pool-1-thread-2] taskD start  
09:12:11.865 [pool-1-thread-1] taskC finish   
09:12:11.867 [pool-1-thread-2] taskD finish  
09:12:12.863 [     main] == Task Complete==   
09:12:12.865 [     main] pool= 2, active= 0, queuedTasks= 0, completedTask= 4  
09:12:12.872 [     main] == Shutdown Complete ==  
09:12:12.875 [     main] pool= 0, active= 0, queuedTasks= 0, completedTask= 4  
```

## ThreadPoolExecutor constructor
- `corePoolSize`: basic # of threads managed in thread pool
- `maximumPoolSize`: maximum # of threads in the pool
- `keepAliveTime`, `TimeUnit unit`
- `LinkedBlockingQueue`