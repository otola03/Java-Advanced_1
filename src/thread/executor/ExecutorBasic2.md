# ExecutorService bulk execution

### **invokeAll()**
- `<T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws
InterruptedException`
    - submit all Callable tasks, wait for the completion of all the tasks.
- `<T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long
timeout, TimeUnit unit) throws InterruptedException`
    - timeout

### **invokeAny()**
- `<T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException`
    - wait for only one Callable task, return the first completed task's result.
    - cancel all the other tasks.
- `<T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException`
    - timeout
