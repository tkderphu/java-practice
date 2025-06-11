package concurrent.mq;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SimpleMessageQueue {
    private Queue<BusinessMessage> queue = new LinkedList<>();
    private final Map<BusinessType, BusinessHandler> handlers = new HashMap<>();
    private int CAPACITY;
    private boolean shutdown = false;

    public Queue<BusinessMessage> getQueue() {
        return queue;
    }

    public void setQueue(Queue<BusinessMessage> queue) {
        this.queue = queue;
    }

    public Map<BusinessType, BusinessHandler> getHandlers() {
        return handlers;
    }

    public int getCAPACITY() {
        return CAPACITY;
    }

    public void setCAPACITY(int CAPACITY) {
        this.CAPACITY = CAPACITY;
    }

    public boolean isShutdown() {
        return shutdown;
    }

    public void setShutdown(boolean shutdown) {
        this.shutdown = shutdown;
    }

    public SimpleMessageQueue(int CAPACITY) {
        this.CAPACITY = CAPACITY;
        registerHandler();
    }

    private void registerHandler() {
        handlers.put(BusinessType.NOTIFICATION, new NotificationHandler());
        handlers.put(BusinessType.ORDER_PROCESSING, new OrderProcessingHandler());
    }


    public void sendMessage(BusinessType type, String content, Map<String, Object> data) throws InterruptedException {
        BusinessMessage businessMessage = new BusinessMessage(content, type, data);
        synchronized (this) {
            while (queue.size() >= CAPACITY && !shutdown) {
                System.out.println("Queue is full, producer is waiting...");
                wait();
            }

            if(shutdown) {
                throw new IllegalStateException("Queue is shutdown");
            }

            queue.add(businessMessage);
            System.out.println("SENT: " + businessMessage + " | Queue size: " + queue.size());
            notify();
        }
    }

    public void produceMessage() {
        try {
            BusinessMessage message;

            synchronized (this) {
                while (queue.isEmpty() && !shutdown) {
                    System.out.println("Queue is empty, consumer is waiting...");
                    wait();
                }
                if (shutdown && queue.isEmpty()) {
                    return;
                }
                message = queue.poll();
                if (message != null) {
                    System.out.println("RECEIVED: " + message + " | Queue size: " + queue.size());
                    handleMessage(message);
                }
            }
        } catch (InterruptedException rx) {
            Thread.currentThread().interrupt();
        }
    }

    private void handleMessage(BusinessMessage message) {
        BusinessHandler handler = handlers.get(message.getType());

        if (handler != null) {
            try {
                handler.handle(message);
            } catch (Exception e) {
                System.err.println("Error handling message: " + e.getMessage());
            }
        } else {
            System.err.println("No handler found for business type: " + message.getType());
        }
    }

    public void shutdown() {
        synchronized (this) {
            shutdown = true;
            notifyAll();
        }
    }

    public int size() {
        synchronized (this) {
            return queue.size();
        }
    }
}
