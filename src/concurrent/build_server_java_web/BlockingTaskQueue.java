package concurrent.build_server_java_web;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingTaskQueue {
    private Queue<Runnable> queue = new LinkedList<>();
    private int capacity;
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public BlockingTaskQueue(int capacity) {
        this.capacity = capacity;
    }

    public void put(Runnable task) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                System.out.println("Queue full");
                notFull.await();
            }
            queue.offer(task);
            notEmpty.signal(); // Signal that a task is available
        } finally {
            lock.unlock();
        }
    }

    public Runnable take() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                System.out.println("Queue empty");
                notEmpty.await();
            }
            Runnable task = queue.poll();
            notFull.signal(); // Signal that space is available
            return task;
        } finally {
            lock.unlock();
        }
    }

    public boolean isEmpty() {
        lock.lock();
        try {
            return queue.isEmpty();
        } finally {
            lock.unlock();
        }
    }


}
