package util;
import static util.MyLogger.*;

public abstract class ThreadUtils {
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch(InterruptedException e) {
            log("Interruption Occured, " + e.getMessage());
            throw new RuntimeException(); // unchecked exception
        }
    }
}