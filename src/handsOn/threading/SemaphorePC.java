//package handsOn.threading;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.concurrent.Semaphore;
//
//public class SemaphorePC {
//    // 1. Queue to hold data
//    private final Queue<Integer> buffer = new LinkedList<>();
//    private final int CAPACITY = 5;
//
//    // 2. The Semaphores
//    private final Semaphore semProducer = new Semaphore(CAPACITY); // Start with 5 empty slots
//    private final Semaphore semConsumer = new Semaphore(0);        // Start with 0 full slots
//    private final Semaphore mutex = new Semaphore(1);              // Binary semaphore for locking
//
//    public void produce(int item) throws InterruptedException {
//        semProducer.acquire(); // Wait for an empty slot
//
//        mutex.acquire();       // Lock the queue
//        try {
//            buffer.add(item);
//            System.out.println("Produced: " + item);
//        } finally {
//            mutex.release();   // Unlock the queue
//        }
//
//        semConsumer.release(); // Signal that a new item is available
//    }
//
//    public void consume() throws InterruptedException {
//        semConsumer.acquire(); // Wait for a full slot
//
//        mutex.acquire();       // Lock the queue
//        try {
//            int item = buffer.poll();
//            System.out.println("Consuming : " + item);
//            Thread.sleep(5000);
//            System.out.println("consumed : "+ item);
//        } finally {
//            mutex.release();   // Unlock the queue
//        }
//
//        semProducer.release(); // Signal that a slot is now empty
//    }
//
//    public static void main(String[] args) {
//        SemaphorePC spc = new SemaphorePC();
//
//        new Thread(() -> {
//            try {
//                for (int i = 1; i <= 10; i++) spc.produce(i);
//            } catch (InterruptedException e) { e.printStackTrace(); }
//        }).start();
//
//        new Thread(() -> {
//            try {
//                for (int i = 1; i <= 10; i++) spc.consume();
//            } catch (InterruptedException e) { e.printStackTrace(); }
//        }).start();
//    }
//}



package handsOn.threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SemaphorePC {
    public static void main(String[] args) {
        // Capacity of 1 ensures strict turn-taking
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);

        // PRODUCER THREAD
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Producer trying to put: " + i);
                    queue.put(i); // Blocks if queue is full
                    System.out.println(">>> Produced: " + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // CONSUMER THREAD
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    Thread.sleep(2000); // Simulate slow consumer
                    int item = queue.take(); // Blocks if queue is empty
                    System.out.println("<<< Consumed: " + item);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}