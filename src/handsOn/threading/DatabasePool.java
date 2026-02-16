package handsOn.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class DatabasePool {
    public static void main(String[] args) {
        // 1. The Gatekeeper: Only 3 permits available
        Semaphore connectionPool = new Semaphore(3);

        // 2. The Workers: 6 threads trying to work
        ExecutorService executor = Executors.newFixedThreadPool(6);

        for (int i = 1; i <= 6; i++) {
            int threadId = i;
            executor.execute(() -> {
                try {
                    System.out.println("Thread " + threadId + " is waiting for a connection...");

                    // Grab the permit
                    connectionPool.acquire();

                    System.out.println(">>> Thread " + threadId + " secured a connection.");
                    Thread.sleep(2000); // Simulate database work

                    System.out.println("<<< Thread " + threadId + " is releasing connection.");

                    // Return the permit
                    connectionPool.release();

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        executor.shutdown();
    }
}