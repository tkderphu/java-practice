package design_pattern.behavioral.mediator;

public class UserImpl extends User {

    public UserImpl(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
    }
    @Override
    public void send(String message) {
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(String.format("%s received message: %s", username, message));
    }
}
