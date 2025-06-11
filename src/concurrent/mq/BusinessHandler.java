package concurrent.mq;

public interface BusinessHandler {
    void handle(BusinessMessage businessMessage);
    BusinessType getHandlerType();
}
