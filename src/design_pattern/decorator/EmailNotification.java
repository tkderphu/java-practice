package design_pattern.decorator;

public class EmailNotification extends Notification {

    private Notification notification;

    public EmailNotification(Notification notification) {
        this.notification = notification;
    }
    @Override
    void send() {
        notification.send();
        System.out.println("Email notification");
    }
}
