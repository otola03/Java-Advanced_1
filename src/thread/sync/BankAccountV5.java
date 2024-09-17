package thread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;
import static util.ThreadUtils.*;

public class BankAccountV5 implements BankAccount {

    private int balance;

    private final Lock lock = new ReentrantLock();

    public BankAccountV5(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("Starting Transaction: " + getClass().getSimpleName());

        if(!lock.tryLock()) { // 락을 못얻으면 포기
            log("[진입 실패] 이미 처리중인 작업이 있음.");
            return false;
        }

        lock.lock(); // ReentrantLock 이용 > lock 걸기 
        // try - finally 블록으로 unlock 필수적으로 해줘야함. 
        try {
            // 임계영역 (Critical Section) 시작
            log("[Verification Started] Withdrawl: " + amount + ", Balance: " + balance);
            // balance < amount -> return false
            if(balance < amount) {
                log("[Transaction Failed] Withdrawal: " + amount + ", Balance: " + balance);
                return false; 
            }

            // balance >= amount -> proceed
            log("[Verification Complete] Withdrawal: " + amount + ", Balance: " + balance);
            sleep(1000); // time for withdrawal
            balance -= amount;
            log("[Withdrawal Complete] Withdrawal: " + amount + ", Balance: " + balance);
            // 임계영역 (Critical Section) 종료
        } finally {
            lock.unlock(); // 반드시 unlock 해줘야 
        }

       
        
        log("Transaction Complete");
        return true;
    }

    @Override
    public int getBalance() {
        lock.lock(); // ReentrantLock 이용 > lock 걸기 
        // try - finally 블록으로 unlock 필수적으로 해줘야함. 
        try {
            return balance;
        } finally {
            lock.unlock(); // 반드시 unlock 해줘야 
        }
    }
    
}
