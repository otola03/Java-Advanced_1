## Advanced Synchronization - **concurrent.Lock**

---

### **synchronized** drawbacks

1. infinite wait: `BLOCKED` state
2. Which thread will acquire the lock?

### **LockSupport**

no infinite waiting

- park(): change thread's state to `WAITING`
- parkNanos(nanosec): `TIMED_WAITING` for nano sec
- unpark()