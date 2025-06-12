package concurrent.lock;

import java.util.ArrayList;
import java.util.List;

public class ExecutorService {
    private final BlockingTaskQueue taskQueue;
    private final List<Worker> workers;
    private volatile boolean isShutdown = false;

    public ExecutorService(int numThreads, int queueCapacity) {
        this.taskQueue = new BlockingTaskQueue(queueCapacity);
        this.workers = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            Worker worker = new Worker(taskQueue, i);
            worker.start();
            workers.add(worker);
        }
    }

    public void submit(Runnable task) throws InterruptedException {
        if (isShutdown) {
            throw new IllegalStateException("ExecutorService is shut down.");
        }
        taskQueue.put(task);
    }

    public void shutdown() {
        isShutdown = true;
        for (Worker worker : workers) {
            worker.shutdown();
        }
    }
}
