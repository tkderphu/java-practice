package concurrent.mq;

public class OrderProcessingHandler implements BusinessHandler{

    @Override
    public void handle(BusinessMessage businessMessage) {
        System.out.println(String.format("""
                Order processing:
                    Content: %s,
                    orderId: %s,
                    customerId: %s,
                    amount: %s
                    
        """, businessMessage.getContent(), businessMessage.getData().get("orderId"),
                businessMessage.getData().get("customerId"), businessMessage.getData().get("amount")));
    }

    @Override
    public BusinessType getHandlerType() {
        return BusinessType.ORDER_PROCESSING;
    }
}
