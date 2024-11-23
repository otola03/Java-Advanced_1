package thread.executor.test;

import java.util.concurrent.ExecutionException;

public class NewOrderServiceMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        NewOrderService orderService = new NewOrderService();
        orderService.order("1");
        orderService.order("2");
        orderService.order("3");
    }
}
