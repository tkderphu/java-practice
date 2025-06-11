package concurrent.mq;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class BusinessMessageProducer implements Runnable{
    private final SimpleMessageQueue queue;
    private final String producerName;
    private final Queue<ProducerTask> taskQueue = new LinkedList<>();
    private boolean running = true;
    private final AtomicInteger taskCounter = new AtomicInteger(0);

    public BusinessMessageProducer(SimpleMessageQueue queue, String producerName) {
        this.queue = queue;
        this.producerName = producerName;
    }


    @Override
    public void run() {
        try {
            while(running || !taskQueue.isEmpty()) {
                ProducerTask task = null;

                synchronized (this) {
                    while (taskQueue.isEmpty() && running) {
                        System.out.println("⏳ [" + producerName + "] Waiting for new tasks...");
                        wait();
                    }

                    if (!taskQueue.isEmpty()) {
                        task = taskQueue.poll();
                    }
                }

                if (task != null) {
                    processTask(task);
                    Thread.sleep(500); // Simulate processing time
                }
            }

        System.out.println("🏁 [" + producerName + "] Finished. Total tasks processed: " +
                taskCounter.get());
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    // Convenient method to add task with parameters
    public void addTask(BusinessType type, String content, Map<String, Object> data) {
        addTask(new ProducerTask(type, content, data));
    }

    private void addTask(ProducerTask producerTask) {
        synchronized (this) {
            taskQueue.add(producerTask);
            taskCounter.incrementAndGet();
            System.out.println("📋 [" + producerName + "] New task added: " + producerTask);
            notify();
        }
    }


    private void processTask(ProducerTask task) throws InterruptedException {
        System.out.println("⚙️ [" + producerName + "] Processing task: " + task);
        queue.sendMessage(task.getBusinessType(), task.getContent(), task.getData());
    }
}
