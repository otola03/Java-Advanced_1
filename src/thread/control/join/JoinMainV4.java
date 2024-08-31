package thread.control.join;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class JoinMainV4 {
    public static void main(String[] args) throws InterruptedException {
        log("Start");
        SumTask task1 = new SumTask(1, 50);

        Thread thread1 = new Thread(task1, "thread-1");
        thread1.start();

        // 스레드가 종료될 때까지 대기
        log("join(1000)- main 스레드가 thread1 종료까지 1sec 대기");
        thread1.join(1000);
        log("main 스레드 대기완료");

        log("task1.res = " + task1.res);
        log("End");
    }    

    static class SumTask implements Runnable {
        int startVal;
        int endVal;
        int res;

        public SumTask(int startVal, int endVal) {
            this.startVal = startVal;
            this.endVal = endVal;
        }

        @Override
        public void run() {
            log("작업 시작");
            sleep(2000); // 작업이 시간이 좀 걸린다고 가정
            int sum = 0;
            for(int i = startVal; i <= endVal; i++) {
                sum += i;
            }
            res = sum;
            log("작업 완료, result = " + res);
        }
    }
}
