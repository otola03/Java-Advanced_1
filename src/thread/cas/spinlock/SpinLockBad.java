/*
 * thread acquires lock -> "lock" true
 * thread returns lock -> "lock" false
 */


package thread.cas.spinlock;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class SpinLockBad {
    
    private volatile boolean lock = false; // flag

    public void lock() {
        log("Lock Acquisition Attempt");
        while(true) {
            if(!lock) { // 1. check lock usage
                sleep(100); // 문제 상황 확인용, 스레드 대기
                lock = true; // change lock value
                break;
            } else { // lock in use (lock = true)
                // 락 획득 때까지 스핀 대기(바쁜 대기)
                log("Lock Acquisition Failed - Spin Wait");
            }
        }
        log("Lock Acquisition Successful");
    }

    public void unlock() {
        lock = false; // atomic operation (원자적 연산) -> no multithread related problems
        log("Lock Return Successful");
    }
}

