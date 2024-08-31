package thread.sync;

import static util.Logger.log;

public class BankAccountV1 implements BankAccount {

    private int balance;

    public BankAccountV1(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());

        return false;
    }

    @Override
    public int getBalance() {
        return 0;
    }
    
}
