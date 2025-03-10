package design_pattern.behavioral.mediator;

/**
 * what is mediation design pattern:
 *  mediator design pattern allow many object can interact with each other
 *  example: when you have 2 user and you want them chat with each other
 *
 */
public interface ChatMediator {
    void sendMessage(String msg, User user);
    void addUser(User user);
}
