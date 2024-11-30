# ExecutorService cancellation methods

**graceful shutdown**: Graceful shutdown is the process of allowing an ExecutorService to finish executing its current tasks before shutting down. This ensures that tasks are completed in an orderly manner, preventing data corruption or unexpected behavior.

## **Service cancellation**
### `void shutdown()`
- reject new task, complete all received tasks and shutdown
- non-blocking method (이 메서드를 호출한 스레드는 바로 다음으로 넘어감)

### `List<Runnable> shutdownNow()`
- cancel current task, return tasks in queue
- interrupt to cancel current task
- non-blocking method

## **Service state check**
### `boolean isShutdown()`
- check if service closed

### `boolean isTerminated()`
- check task completion after `shutdown()` and `shutdownNow()`

## **Task completion wait**
### `boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException`
- wait for all tasks' completion (timout)
- blocking method

## **close()**
### `close()`
- from java 19
- call `shutdown()`, task takes more than a day -> call `shutdownNow()`



