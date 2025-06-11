package concurrent.mq;

import java.util.concurrent.atomic.AtomicInteger;

public class BusinessMessageConsumer implements Runnable{
    private SimpleMessageQueue simpleMessageQueue;
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private String name;
    public BusinessMessageConsumer(SimpleMessageQueue simpleMessageQueue, String name) {
        this.simpleMessageQueue = simpleMessageQueue;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while(!simpleMessageQueue.isShutdown() || simpleMessageQueue.size() > 0) {
                simpleMessageQueue.produceMessage();
                atomicInteger.incrementAndGet();

                Thread.sleep(100);
            }
            System.out.println(name + " finished. Processed " +
                    atomicInteger.get() + " messages");
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
