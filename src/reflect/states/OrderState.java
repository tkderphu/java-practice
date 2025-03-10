package reflect.states;

public interface OrderState {
    void printStatus();
    void next(Order order);
    void prev(Order order);

}
