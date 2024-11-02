package thread.cas.spinlock;

import static util.MyLogger.*;

import java.util.concurrent.atomic.AtomicBoolean;

public class SpinLock {
    
    private final AtomicBoolean lock = new AtomicBoolean(); // default val: false

    public void lock() {
        log("Lock Acquisition Attempt");
        // exits while loop if thread acquires lock
        while(!lock.compareAndSet(false, true)) { 
            // spin wait
            log("Lock Acquisiton Failed");
        }
        log("Lock Acquisition Successful");
    }

    public void unlock() {
        lock.set(false); // Unconditionally sets to the given value.
        log("Lock Return Successful");
    }
}

