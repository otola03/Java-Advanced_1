# Executor thread pool maintenance

### `ThreadPoolExecutor` that implements `ExecutorService`
- `corePoolSize`: basic # of threads in thread pool
- `maximumPoolSize`: maximum # of threads 
- `keepAliveTime`, `TimeUnit unit`: survival time for extra threads (if extra threads don't work in this time, they are terminated)
- `BlockingQueue workQueue`: queue for tasks

