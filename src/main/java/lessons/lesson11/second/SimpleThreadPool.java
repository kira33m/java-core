package lessons.lesson11.second;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SimpleThreadPool {
    private final BlockingQueue<Runnable> taskQueue;
    private final List<Worker> workers;
    private volatile boolean isShutdown = false;

    private static final Runnable POISON = () -> {};

    public SimpleThreadPool(int nThreads) {
        this(nThreads, Integer.MAX_VALUE);
    }

    public SimpleThreadPool(int nThreads, int queueCapacity) {
        if (nThreads <= 0) throw new IllegalArgumentException("nThreads must be > 0");
        if (queueCapacity <= 0) throw new IllegalArgumentException("queueCapacity must be > 0");

        this.taskQueue = new LinkedBlockingQueue<>(queueCapacity);
        this.workers = new ArrayList<>(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Worker worker = new Worker("simple-pool-worker-" + i);
            workers.add(worker);
            worker.start();
        }
    }

    public void submit(Runnable task) {
        if (task == null) throw new NullPointerException("task == null");
        if (isShutdown) throw new IllegalStateException("ThreadPool is shut down");

        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while submitting task", e);
        }
    }

    public void shutdown() {
        isShutdown = true;
        for (int i = 0; i < workers.size(); i++) {
            try {
                taskQueue.put(POISON);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void awaitTermination() {
        for (Worker w : workers) {
            try {
                w.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private final class Worker extends Thread {
        Worker(String name) {
            super(name);
            setDaemon(false);
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Runnable task = taskQueue.take();
                    if (task == POISON) {
                        break;
                    }
                    try {
                        task.run();
                    } catch (Throwable t) {
                        System.err.println(getName() + " поймал исключение в задаче: " + t);
                        t.printStackTrace(System.err);
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}