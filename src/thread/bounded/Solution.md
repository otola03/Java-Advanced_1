# Solution
- producer awakes consumer 
- consumer awakes producer 

=> divide "waiting set" using ***Lock interface & ReentrantLock***.

`Lock lock = new ReentrantLock` instead of `synchronized`

## Condition
`Condition condition = lock.newCondition()`

`Condition` is a thread waiting space(스레드 대기 공간) for threads using `ReentrantLock`


### condition.await()
Object.wait() function

### condition.signal()
Object.notify() function