package design_pattern.decorator;

public class SMSNotification extends Notification{
    private Notification notification;

    public SMSNotification() {

    }
    public SMSNotification(Notification notification) {
        this.notification = notification;
    }

    @Override
    void send() {
        notification.send();
        System.out.println("SMS notification");
    }
}
