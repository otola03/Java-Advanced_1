# **Future** - analysis
```java
 Future<Integer> future = es.submit(new MyCallable());
 ```
 - `submit()` returns `Future` instead of the Random number
 - A thread inside the thread pool runs `MyCallable.call()`
 - so it's impossible to get the result instantly
 - => `es.submit()` provides `Future` object that can get `MyCallable` result later.
 - In other words, `Future` contains the future of the task.

 ### Blocking method
 `Thread.join()`, `future.get()`, ... => awaits thread until other tasks' completion


 ### Future used properly
 ```java
 Future future1 = es.submit(new SumTask(1, 50)); // non blocking
 Future future2 = es.submit(new SumTask(51, 100));  // non blocking

 Integer res1 = future1.get(); // blocking, takes 2000ms
 Integer res2 = future2.get(); // blocking, almost instant return(2000ms from res1)
 ```
 => takes 2000ms (**Multi-Thread powerrr**)

 ### Future used incorrectly
 ```java
 Future future1 = es.submit(new SumTask(1, 50)); // non blocking
 Integer res1 = future1.get(); // blocking, takes 2000ms

 Future future2 = es.submit(new SumTask(51, 100));  // non blocking
 Integer res2 = future2.get(); // blocking, takes 2000ms)
 ```
or
 ```java
 Integer res1 = es.submit(new SumTask(1, 50)).get();   // blocking at get() 2000ms 
 Integer res2 = es.submit(new SumTask(51, 100)).get(); // blocking at get() 2000ms
 ```

 => takes 4000ms