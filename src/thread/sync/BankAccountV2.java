package thread.sync;

import static util.MyLogger.log;
import static util.ThreadUtils.*;

public class BankAccountV2 implements BankAccount {

    private int balance;

    public BankAccountV2(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public synchronized boolean withdraw(int amount) {
        log("Starting Transaction: " + getClass().getSimpleName());

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

        log("Transaction Complete");
        return true;
    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
    
}
