package reflect.states;

public class ShipState implements OrderState{
    @Override
    public void printStatus() {
        System.out.println("Ship state");
    }

    @Override
    public void next(Order order) {
        order.setOrderState(new DeliverState());
        System.out.println("Order da duoc giao");
    }

    @Override
    public void prev(Order order) {
        order.setOrderState(new ProcessState());
        System.out.println("Order dang duoc xu ly");
    }
}
