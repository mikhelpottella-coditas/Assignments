package week3AssignmentProblems;

import java.util.concurrent.CountDownLatch;

//public class P6_waitLatch {
//
//}

import java.util.concurrent.CountDownLatch;

class RelayRunner implements Runnable {
    private String name;
    private CountDownLatch waitLatch;   // Latch to wait on
    private CountDownLatch signalLatch; // Latch to trigger for the next person

    public RelayRunner(String name, CountDownLatch waitLatch, CountDownLatch signalLatch) {
        this.name = name;
        this.waitLatch = waitLatch;
        this.signalLatch = signalLatch;
    }

    @Override
    public void run() {
        try {
            // 1. Wait for the baton (unless you are the first runner)
            if (waitLatch != null) {
                System.out.println(name + " is waiting for the baton...");
                waitLatch.await();
            }

            // 2. Run the lap
            System.out.println(">>> " + name + " started running! <<<");
            Thread.sleep((long) (Math.random() * 2000));
            System.out.println(name + " finished their lap.");

            // 3. Pass the baton
            if (signalLatch != null) {
                System.out.println(name + " passed the baton.");
                signalLatch.countDown(); // Decrements the count by 1
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class P6_waitLatch {
    public static void main(String[] args) {
        // Latch for Runner 2 to wait for Runner 1
        CountDownLatch baton1 = new CountDownLatch(1);
        // Latch for Runner 3 to wait for Runner 2
        CountDownLatch baton2 = new CountDownLatch(1);

        // Runner 1: No waitLatch, signals baton1
        Thread r1 = new Thread(new RelayRunner("Runner 1", null, baton1));
        // Runner 2: Waits for baton1, signals baton2
        Thread r2 = new Thread(new RelayRunner("Runner 2", baton1, baton2));
        // Runner 3: Waits for baton2, signals nothing (null)
        Thread r3 = new Thread(new RelayRunner("Runner 3", baton2, null));

        System.out.println("--- Relay Race Starts! ---");
        r3.start(); // We can start them in any order; they will wait!
        r2.start();
        r1.start();
    }
}

