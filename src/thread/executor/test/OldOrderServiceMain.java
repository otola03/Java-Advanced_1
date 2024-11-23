package thread.executor.test;

import static util.MyLogger.*;

public class OldOrderServiceMain {
    public static void main(String[] args) {
        OldOrderService orderService = new OldOrderService();
        orderService.order("2");
    }
}
