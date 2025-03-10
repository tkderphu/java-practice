package design_pattern.decorator;

public class AppNotification extends Notification{
    private Notification notification;
    public AppNotification(Notification notification) {
        this.notification = notification;
    }
    public AppNotification() {

    }

    @Override
    void send() {
        notification.send();
        System.out.println("App notification");
    }
}
