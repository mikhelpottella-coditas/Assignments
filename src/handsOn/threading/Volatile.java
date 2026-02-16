//package handsOn.threading;
//
//public class Volatile {
//        volatile int counter = 0;
//        final static Object lock = new Object();
//    public static void main(String[] args) {
//        Volatile v= new Volatile();
//        Thread t1 = new Thread(()->{
//            synchronized (lock){
//            for (int i = 0; i < 10; i++) {
//                v.counter++;
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println("increased the counter");
//            lock.notify();
//            }
//            }
//        });
//        Thread t2 = new Thread(()->{
//            synchronized (lock) {
//                for (int i = 0; i < 10; i++) {
//
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    System.out.println("reading the counter " + v.counter);
//                    lock.notify();
//                }
//
//            }
//        });
//
//        t1.start();
//        t2.start();
//    }
//}
package handsOn.threading;

public class Volatile {
    int counter = 0;
    final static Object lock = new Object();

    public static void main(String[] args) {
        Volatile v = new Volatile();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (v) {
                    v.counter++;
                    System.out.println("T1 increased counter to: " + v.counter);

                    v.notify(); // Wake up T2
                    try {
                        if (i < 9) v.wait(); // T1 sleeps and drops the lock
                    } catch (InterruptedException e) { e.printStackTrace(); }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (v) {
                    System.out.println("T2 reading counter: " + v.counter);

                    v.notify(); // Wake up T1
                    try {
                        if (i < 9) v.wait(); // T2 sleeps and drops the lock
                    } catch (InterruptedException e) { e.printStackTrace(); }
                }
            }
        });

        t1.start();
        t2.start();
    }
}