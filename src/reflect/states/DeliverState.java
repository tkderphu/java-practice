package reflect.states;

public class DeliverState implements OrderState{
    @Override
    public void printStatus() {
        System.out.println("Deliver state");
    }

    @Override
    public void next(Order order) {
        System.out.println("don hang da duoc giao");
    }

    @Override
    public void prev(Order order) {
        order.setOrderState(new ShipState());
        System.out.println("Order dang duoc ship");
    }
}
