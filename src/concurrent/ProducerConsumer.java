package concurrent;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer  {
    private Queue<Integer> queue = new LinkedList<>();
    private int capacity;

    public ProducerConsumer(int capacity) {
        this.capacity = capacity;
    }

    public void produce() throws InterruptedException {
        int value = 0;
        while(true) {
            synchronized (this) {
                while(queue.size() == capacity) {
                    System.out.println("Queue is full, producer is waiting");
                    this.wait();
                }
                queue.add(++value);
                System.out.println("Produced: " + value + " | Queue size: " + queue.size());

                this.notify();
            }
            Thread.sleep(1000);
        }
    }

    public void consume() throws InterruptedException {
        while(true) {
            synchronized (this) {
                while(queue.isEmpty()) {
                    System.out.println("Queue is empty, consumer is waiting");
                    this.wait();
                }
                int value = queue.poll();
                System.out.println("Consumed: " + value + " | Queue size: " + queue.size());

                this.notify();
            }
            Thread.sleep(1500);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer(5);
        Thread producer = new Thread(() -> {
            try {
                producerConsumer.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                producerConsumer.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer.start();


        try {
            Thread.sleep(10000);
            producer.interrupt();
            consumer.interrupt();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
