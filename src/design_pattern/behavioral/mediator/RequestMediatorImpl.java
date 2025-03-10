package design_pattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class RequestMediatorImpl implements RequestMediator{
    private List<Register> registers;
    public RequestMediatorImpl() {
        this.registers = new ArrayList<>();
    }
    @Override
    public void saveRequest(Register register) {
        registers.add(register);
    }

    @Override
    public void showListRequest() {
        registers.stream().forEach(System.out::println);
    }
}
