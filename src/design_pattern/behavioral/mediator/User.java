package design_pattern.behavioral.mediator;

public abstract class User {
    protected ChatMediator mediator;
    protected String username;


    public abstract void send(String message);
    public abstract void receive(String message);

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
