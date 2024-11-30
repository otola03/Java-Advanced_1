## overall process explained

1. request task1 
2. check if # of thread in the pool == core size
3. no, so create thread1
4. thread1 runs task1

---
1. request task3
2. check if # of thread in the pool == core size
3. yes, so put thread3 to queue

now, task3 and task4 in the queue

---
1. request task5
2. check if # of thread in the pool == core size
3. queue full!

**emergency**-> `Executor` creates extra threads (limit: `maximumPoolSize`)
---
1. thread3 runs task5  
(task5 run before task3)
---
1. thread4 created, runs task6
---
1. task7: `RejectedExecutionException`
---
1. thread1 -> task3, thread-3 -> task4
---
poolSize = 4
---
3000ms passes (timeout) -> extra threads(thread3, thread4) 
terminated

poolSize = 2
---
`shutdown()` -> poolSize = 0




