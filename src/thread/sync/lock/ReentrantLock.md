# ReentrantLock

### **synchronized** drawbacks
1. infinite waiting
2. equality (which thread acquires lock)

### Lock interface
---
#### infinite waiting problem

- `void lock()`: acquires lock/ `WAITING` until lock acquired/ can't interrupt
- `void lockInterruptibly()`: can interrupt
- `boolean tryLock()`: True if lock acquired successfully, False otherwise
- `boolean tryLock(long time, TimeUnit unit)`: ..
- `void unlock()`: releases lock/ called by the thread with the lock (or `IllegalMonitorStateException`)

---
#### equality

**ReentrantLock** -> fairness & non-fair

##### 1. non-fair

- performance (acquire lock quickly)
- new thread might acquire lock first
- a thread might not acquire lock forever

##### 2. fair

`new ReentrantLock(true)` 

- FIFO in thread waiting queue
- every thread will acquire lock at sometime
- performance lowered
