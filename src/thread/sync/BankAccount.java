package thread.sync;

public interface BankAccount {
    
    boolean withdraw(int account);

    int getBalance();
}