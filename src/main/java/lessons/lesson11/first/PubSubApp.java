package lessons.lesson11.first;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PubSubApp {
    private static final String EXIT = "exit";

    private final BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();
    private volatile boolean running = true;
    private final Thread subscriberThread;

    public PubSubApp() {
        this.subscriberThread = new Thread(this::subscriberWorker, "Subscriber-Thread");
        this.subscriberThread.start();
    }

    public void publish(String message) {
        if (!running) return;
        try {
            messageQueue.put(message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void subscriberWorker() {
        try {
            while (true) {
                String message = messageQueue.take();
                if (EXIT.equalsIgnoreCase(message)) {
                    break;
                }
                System.out.println(message);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            running = false;
        }
    }

    public void awaitTermination() {
        try {
            subscriberThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        PubSubApp pubSub = new PubSubApp();
        System.out.println("Pub/Sub App started. Type 'exit' to quit.");

        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) continue;

                pubSub.publish(input);
                if (EXIT.equalsIgnoreCase(input)) {
                    break;
                }
            }
        }

        pubSub.awaitTermination();
        System.out.println("Pub/Sub App stopped.");
    }
}