package reflect.states;

public class Order {
    private OrderState orderState;

    public Order() {
        this.orderState = new ProcessState();
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }
}
