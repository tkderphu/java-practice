package reflect.states;

import java.util.Arrays;

public class ProcessState implements OrderState {
    @Override
    public void printStatus() {
        System.out.println("Process state");
    }

    @Override
    public void next(Order order) {
        order.setOrderState(new ShipState());
        System.out.println("order dang duoc van chuyen");
    }

    @Override
    public void prev(Order order) {
        System.out.println("order dang o trang thai xu ly");
    }
}
