package lessons.lesson11.second;

public class SimpleThreadPoolDemo {
    public static void main(String[] args) {
        SimpleThreadPool pool = new SimpleThreadPool(10);

        for (int i = 1; i <= 25; i++) {
            final int id = i;
            pool.submit(() -> {
                System.out.println(Thread.currentThread().getName()
                    + " выполняет задачу #" + id);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(Thread.currentThread().getName()
                    + " завершил задачу #" + id);
            });
        }

        pool.shutdown();
        pool.awaitTermination();

        System.out.println("Все задачи выполнены, пул завершён.");
    }
}