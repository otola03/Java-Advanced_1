# Proxy

`ArrayList` -> `SyncArrayList`  
`LinkedList` -> `LinkedList` 

=> Too complicated!!


### Proxy (대리자)

```
07:24:35.359 [     main] SyncProxyList  
07:24:35.473 [ Thread-1] Thread-1: list.add(A)  
07:24:35.574 [ Thread-2] Thread-2: list.add(B)  
07:24:35.575 [     main] [A, B], size= 2, capcaity= 5 by SyncProxyList
```
synchronization by never modifying `BasicList`  


***Proxy Pattern*** is a structural design pattern in object-oriented programming that provides a surrogate or placeholder for another object to control access to i

