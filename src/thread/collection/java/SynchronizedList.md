```
class java.util.Collections$SynchronizedRandomAccessList  
list= [data1, data2, data2]
```

client -> `ArrayList`

client -> `SynchronizedRandomAccesList` **(Proxy)** -> `ArrayList`

- `synchronizedList()`
- `synchronizedCollection()`
- `synchronizedMap()`  
etc


### Drawbacks

- costly
- time consuming, not efficient
- over-synchronization


### => java offers `java.util.concurrent` package (concurrent collection)