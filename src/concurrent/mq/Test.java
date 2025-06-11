package concurrent.mq;

public class Test {
    public static void main(String[] args) {
        SimpleMessageQueue simpleMessageQueue = new SimpleMessageQueue(5);
        BusinessMessageProducer producer = new BusinessMessageProducer(simpleMessageQueue, "Producer");
        BusinessMessageConsumer consumer1 = new BusinessMessageConsumer(simpleMessageQueue, "Consumer-1");
        BusinessMessageConsumer consumer2 = new BusinessMessageConsumer(simpleMessageQueue, "Consumer-2");
        InteractionMode interactionMode = new InteractionMode(producer);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer1);
        Thread t3 = new Thread(consumer2);
        Thread t4 = new Thread(interactionMode);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
