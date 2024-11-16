## **Runnable** interface
```java
package java.lang;

public interface Runnable {
    void run();
}
```

- no return value (`void`)
- can't throw *Checked Exception*

## **Callable** interface
```java
package java.util.concurrent;

public interface Callable<V> {
    V call() throws Exception;
}
```
- return type: `V`
- throws `Exception`: all methods implementing this interface can throw *Checekd Exceptions* (`Exception`) and its sub-exceptions

---
Before:
```java
 ExecutorService es = new ThreadPoolExecutor(1, 1, 0, 
                            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
```                
After:            
```java
ExecutorService es = Executors.newFixedThreadPool(1);
```

### **MyCallable**
- `<Intger>` return type
- returns value
- `submit()` instead of `execute()`

Task result passes through the interface called **Future**  
`future.get()` -> get the result from `call()`


# **Exceutor Framework**'s advantages
- concise (no thread creation, no `join()`, ...)

## When `main thread` runs `future.get()`
There are two scenarios...
1. Thread that handles `MyCallable` task completed it.
2. Thread did not complete the task yet. (still handling the task)

Why go through a specific interface called **Future**?