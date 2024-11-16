# Problems with using Thread directly

## 1. Performance
1. Memory allocation
2. OS resources use
3. OS scheduler use

**Thread creation is heavy(costly)**  
=> Reusing already-creatd threads?

## 2. Thread Management
CPU, memory resources... are limited

## 3. Runnalbe interface
- no return value: can't directly receive thread's result
- handling exceptions: run() method cannot throw checked exception (need to be handled inside using try-catch)


# Executor Framework

## Executor interface
```java
package java.util.concurrent;
public interface Executor {
    void execute(Runnable command);
}
```
## ExecutorService interface (Mostly used)
### ThreadPoolExecutor class



