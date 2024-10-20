# Problems with Lock-based methods

```synchronized``` or ```Lock(ReentrantLock)```

### Acquiring and Unlocking takes time
1. check lock
2. acquire lock and enter critical section
3. job done
4. return the lock

This process is repeated every time.
=> time-costly

# CAS (Compare-And-Swap)
**lock-free**

CAS applied in special cases (Use lock as default)
