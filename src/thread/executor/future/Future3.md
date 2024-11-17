# **Future**
## methods
### **boolean cancel(boolean mayInterruptIfRunning)**
- cancel tasks that are not completed
- **parameter**: `mayInterruptIfRunning`
    - `cancel(true)`: change `Future` to cancelled state. If a task is running, use `Thread.interrupt()` to suspend it. 
    - `cancel(false)`: change `Future` to cancelled state. Does not suspend running tasks.
- **return value**: `true` if task successfully cancelled, `false` otherwise
- If call `Futuer.get()` on cancelled `Future`, `CancellationException` runtime error occurs.

### **boolean isCancelled**
- check if a task is cancelled.

### **boolean isDone()**
- check if task is completed
- successfully completed, cancelled, exception occurence => `true`

### **State state()**
- from java v19
    - `RUNNING`
    - `SUCCESS`
    - `FAILED`
    - `CANCELLED`

### V get()
- **Exceptions**
    - `InterruptedException`: thread interrupted
    - `ExecutionException`: exception while computing task
- return result after task completion

### V get(long timeout, TimeUnit unit)
- make exception if time exceeded
- **Exceptions**
    - `InterruptedException`: thread interrupted
    - `ExecutionException`: exception while computing task
    - `TimeoutException`