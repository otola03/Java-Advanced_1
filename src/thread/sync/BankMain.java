package thread.sync;

import static util.MyLogger.log;
import static util.ThreadUtils.*;


public class BankMain {
    public static void main(String[] args) throws InterruptedException{
        BankAccountV5 account = new BankAccountV5(1000);

        Thread t1 = new Thread(new WithdrawTask(account, 800), "t1");
        Thread t2 = new Thread(new WithdrawTask(account, 800), "t2");

        t1.start();
        t2.start();

        sleep(500); // Hold until verification 검증 완료까지 잠시 대기
        log("t1 state: " + t1.getState());
        log("t2 state: " + t2.getState());


        t1.join();
        t2.join();
        
        log("Final Balance: " + account.getBalance());
    }
}
