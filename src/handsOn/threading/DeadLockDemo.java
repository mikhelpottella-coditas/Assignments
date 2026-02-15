package handsOn.threading;

public class DeadLockDemo {
    // Two separate locks (keys)
    static final Object lockSpoon = new Object();
    static final Object lockBowl = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lockSpoon) {
                System.out.println("T1: Holding Spoon...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("T1: Waiting for Bowl...");
                synchronized (lockBowl) {
                    System.out.println("T1: Eating!");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lockBowl) {
                System.out.println("T2: Holding Bowl...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("T2: Waiting for Spoon...");
                synchronized (lockSpoon) {
                    System.out.println("T2: Eating!");
                }
            }
        });

        t1.start();
        t2.start();
    }
}