# SyncTest2

### Prediction

Each thread will use ** EACH localValue ** so the results will be 1000 for both threads.


### Answer

** local value (지역 변수) is never shared with other threads!**

Because local value is created in "stack" for each thread.

