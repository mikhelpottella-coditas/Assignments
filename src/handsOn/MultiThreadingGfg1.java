package handsOn;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

class Counter {
    int count = 0;

    void increment() {
        count++; // Not atomic: multiple threads may interfere
    }
}

public class MultiThreadingGfg1 {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();

        // Thread 1 increments count 1000 times
        Thread t1 = new Thread(() ->{
            for (int i = 0; i < 6000000; i++) {
                c.increment();
                System.out.println("Thread 1" + c.count);
            }
        });

        Thread t3 = new Thread(() ->{
            for (int i = 0; i < 2000000; i++) {
                c.increment();
                System.out.println("Thread 1" + c.count);
            }
        });

        // Thread 2 increments count 1000 times
        Thread t2 = new Thread(() ->{
            for (int i = 0; i < 1000000; i++) {
                c.increment();
                System.out.println("Thread 2 : " + c.count);

            }
        });

        // Start thread 1
        t1.start();

        // Start thread 2
        t2.start();

        t3.start();
        // Wait for thread 1 to finish
        t1.join();

        // Wait for thread 2 to finish
        t2.join();

        t3.join();
        // May be < 2000 due to race condition
        System.out.println("Final Count: " + c.count);
    }
}