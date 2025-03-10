package design_pattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator{
    private List<User> users;

    public ChatMediatorImpl() {
        users = new ArrayList<>();
    }
    @Override
    public void sendMessage(String msg, User user) {
        this.users.stream()
                .filter(u -> !u.getUsername().equals(user.getUsername()))
                .forEach(u -> u.receive(msg));
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }
}
