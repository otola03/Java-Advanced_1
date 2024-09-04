### **synchronized** keyword

create a code block only one thread can run

---

Every instance has its own **lock**.

1. t1 gets the lock
2. t2 can't -> RUNNABLE -> BLOCKED 
3. t2 gets the lock and uses withdrawal() method
4. balance = 200 => Transaction fails

=> t2 fails withdrawal 

=> final balance: $200

