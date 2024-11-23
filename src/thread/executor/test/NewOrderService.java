package thread.executor.test;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NewOrderService {

    public void order(String orderNo) throws InterruptedException, ExecutionException {
        // make thread pool
        ExecutorService es = Executors.newFixedThreadPool(3);

        InventoryWork inventoryWork = new InventoryWork(orderNo);
        ShippingWork shippingWork = new ShippingWork(orderNo);
        AccountingWork accountingWork = new AccountingWork(orderNo);
        try {
            // 작업 요청
            List<Future<Boolean>> resultList = es.invokeAll(List.of(inventoryWork, shippingWork, accountingWork));

            // 결과 확인
            for(Future<Boolean> future: resultList) {
                if(!future.get()) {
                    log("일부 작업이 실패했습니다");
                }
            }
            log("모든 작업 완료");
        }
        finally {
            es.close();
        }
    }

    static class InventoryWork implements Callable<Boolean> {

        private final String orderNo;

        public InventoryWork(String orderNo) {
            this.orderNo = orderNo;
        }
        @Override
        public Boolean call() {
            log("재고 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }

    static class ShippingWork implements Callable<Boolean> {

        private final String orderNo;

        public ShippingWork(String orderNo) {
            this.orderNo = orderNo;
        }
        @Override
        public Boolean call() {
            log("배송 시스템 알림: " + orderNo);
            sleep(1000);
            return true;
        }
    }

    static class AccountingWork implements Callable<Boolean> {

        private final String orderNo;

        public AccountingWork(String orderNo) {
            this.orderNo = orderNo;
        }
        @Override
        public Boolean call() {
            log("회계 시스템 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }

}