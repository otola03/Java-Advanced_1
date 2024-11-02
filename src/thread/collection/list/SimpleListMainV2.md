## BasicList 실행결과 
```
07:02:18.000 [     main] BasicList  
07:02:18.112 [ Thread-1] Thread-1: list.add(A)  
07:02:18.113 [ Thread-2] Thread-2: list.add(B)  
07:02:18.114 [     main] [B, null], size= 2, capacity= 5
```


Thread-1: `elementData[0] = A`  
Thread-2: `elementData[1] = B`

=> `elementData[0]` becomes B, but size = 2 (or size = 1 if size++ is processed at the same time)

#### => Most Collection Framework is not thread-safe!
## SyncList 실행결과
```
07:15:35.852 [     main] SyncList  
07:15:35.979 [ Thread-1] Thread-1: list.add(A)  
07:15:36.080 [ Thread-2] Thread-2: list.add(B)  
07:15:36.081 [     main] [A, B], size= 2, capcaity= 5
```


