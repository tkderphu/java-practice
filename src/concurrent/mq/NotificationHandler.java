package concurrent.mq;

public class NotificationHandler implements BusinessHandler{


    @Override
    public void handle(BusinessMessage businessMessage) {
        System.out.println(String.format("""
                Notification:
                    content: %s,
                    type: %s,
                    message: %s
                    
        """, businessMessage.getContent(), businessMessage.getData().get("type"), businessMessage.getData().get("message")));
    }

    @Override
    public BusinessType getHandlerType() {
        return BusinessType.NOTIFICATION;
    }
}
