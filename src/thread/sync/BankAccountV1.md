Output: 

`04:47:43.569 [       t2] Starting TransactionBankAccountV1


04:47:43.577 [       t1] Starting TransactionBankAccountV1


04:47:43.613 [       t1] [Verification Started] Withdrawl: 800, Balance: 1000


04:47:43.615 [       t2] [Verification Started] Withdrawl: 800, Balance: 1000


04:47:43.615 [       t2] [Verification Complete] Withdrawal: 800, Balance: 1000


04:47:43.614 [       t1] [Verification Complete] Withdrawal: 800, Balance: 1000


04:47:43.868 [     main] t1 state: TIMED_WAITING


04:47:43.872 [     main] t2 state: TIMED_WAITING


04:47:44.616 [       t2] [Withdrawal Complete] Withdrawal: 800, Balance: 200


04:47:44.617 [       t2] Transaction Complete


04:47:44.621 [       t1] [Withdrawal Complete] Withdrawal: 800, Balance: -600


04:47:44.622 [       t1] Transaction Complete


04:47:44.639 [     main] Final Balance: -600`

---

### Problem with Verification Logic <Synchronization Problem>
Time for Withdrawal: 1000ms
=> t2 successfully completes verification because t1 is yet to change the balance.

---

### Critical Section (임계 영역)

Withdrawl() 
1. Verification step: check "balance"
2. Withdrawal step: change "balance"

Assumption for this logic: __"balance" from Step1 (1000$) must <u>stay the same</u> until Step2.__

If another Thread changes "balance" value, things go wrong. 

**Shared Resource (공유자원)** : "balance" is used by multiple threads. It can be changed by other threads any time.

**Critical Section (임계 영역)**(https://www.geeksforgeeks.org/g-fact-70/):


 a critical section refers to a segment of code that is executed by multiple concurrent threads or processes, and which accesses shared resources (geeksforgeeks)

**synchronized** keyword -> take care of critical section
