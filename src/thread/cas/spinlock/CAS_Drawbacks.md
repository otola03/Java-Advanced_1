```
06:14:16.872 [ Thread-2] Lock Acquisition Attempt
06:14:16.878 [ Thread-2] Lock Acquisition Successful
06:14:16.881 [ Thread-2] 비즈니스 로직 실행
06:14:16.881 [ Thread-1] Lock Acquisition Attempt
06:14:16.885 [ Thread-1] Lock Acquisiton Failed
06:14:16.887 [ Thread-1] Lock Acquisiton Failed
06:14:16.888 [ Thread-1] Lock Acquisiton Failed
06:14:16.888 [ Thread-1] Lock Acquisiton Failed
06:14:16.888 [ Thread-1] Lock Acquisiton Failed
06:14:16.889 [ Thread-1] Lock Acquisiton Failed
06:14:16.889 [ Thread-1] Lock Acquisiton Failed
06:14:16.889 [ Thread-1] Lock Acquisiton Failed
06:14:16.890 [ Thread-1] Lock Acquisiton Failed
06:14:16.891 [ Thread-1] Lock Acquisiton Failed
06:14:16.892 [ Thread-1] Lock Acquisiton Failed
06:14:16.892 [ Thread-1] Lock Acquisiton Failed
06:14:16.892 [ Thread-1] Lock Acquisiton Failed
06:14:16.897 [ Thread-1] Lock Acquisiton Failed
06:14:16.897 [ Thread-2] Lock Return Successful
06:14:16.899 [ Thread-1] Lock Acquisition Successful
06:14:16.900 [ Thread-1] 비즈니스 로직 실행
06:14:16.911 [ Thread-1] Lock Return Successful
```


Thread does not go `BLOCKED` or `WAITING` but uses while loop. 

Uses `CPU`resource while waiting for lock!

### When is CAS useful

When the operation is very short (increment, adding data, ...)

=> 상황에 따라 맞는 방법 사용
