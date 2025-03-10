package design_pattern.decorator;

public class Main {
    public static void main(String[] args) {
        Notification appNotification = new AppNotification(
                new EmailNotification(
                        new SMSNotification()
                )
        );
        appNotification.send();

    }
}
