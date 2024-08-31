package thread.control.join;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class JoinMainV1 {
    public static void main(String[] args) {
        log("Start");
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);

        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread-2");
        thread1.start();
        thread2.start();

        log("task1.res = " + task1.res);
        log("task2.res = " + task2.res);

        int sum = task1.res + task2.res;
        log("sum = " + sum);
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
