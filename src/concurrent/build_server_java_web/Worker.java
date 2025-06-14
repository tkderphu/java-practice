package concurrent.build_server_java_web;

class Worker extends Thread {
    private final BlockingTaskQueue taskQueue;
    private volatile boolean running = true;

    public Worker(BlockingTaskQueue taskQueue, int index) {
        super("Worker-" + index);
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (running || !taskQueue.isEmpty()) {
            try {
                Runnable task = taskQueue.take();
                if (task != null) {
                    task.run();
                }
            } catch (InterruptedException e) {
                // Allow thread to exit if shutting down
                Thread.currentThread().interrupt();
            }
        }
    }

    public void shutdown() {
        running = false;
        this.interrupt();
    }
}
