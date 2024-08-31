package thread.start;

public class HelloRunnableMain {
// Suggested code may be subject to a license. Learn more: ~LicenseLog:1005619720.
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        HelloRunnable runnable = new HelloRunnable();
        Thread thread = new Thread(runnable);
        thread.start(); 

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }
}
