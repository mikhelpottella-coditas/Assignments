package handsOn.threading;//package handsOn.threading;
//
//public class ProducerConsumer {
//    boolean plate = false;
//    int items = 6;
//
//    public static void main(String[] args) {
//        ProducerConsumer producer1 = new ProducerConsumer();
//        Thread producer = new Thread(() -> {
//
//            while (producer1.items > 0) producer1.provide();
//        });
//        Thread consumer = new Thread(() -> {
//            while (producer1.items > 0 ) producer1.consume();
//        });
//
//        producer.start();
//        consumer.start();
//    }
//
//    synchronized void provide() {
//        while (plate) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        if (items > 0) {
//            plate = true;
//            items--;
//            System.out.println("the item added tp the plate");
//            notify();
//        }
//    }
//
//    synchronized void consume() {
//        while (!plate) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        plate = false;
//        System.out.println("i consumed the item");
//        notify();
//    }
//}

//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingQueue;
//
//public class ProducerConsumer{
//    public static void main(String[] args) {
//        // A queue that can hold only 1 item at a time
//        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);
//
//        // Producer
//        new Thread(() -> {
//            try {
//                for (int i = 1; i <= 6; i++) {
//                    queue.put(i); // This automatically WAITS if the queue is full
//                    System.out.println("Produced: " + i);
//                }
//            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
//        }).start();
//
//        // Consumer
//        new Thread(() -> {
//            try {
//                for (int i = 1; i <= 6; i++) {
//                    int item = queue.take(); // This automatically WAITS if the queue is empty
//                    System.out.println("Consumed: " + item);
//                }
//            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
//        }).start();
//    }
//}

import java.util.concurrent.ArrayBlockingQueue;


public class ProducerConsumer {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);
        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread t1 = new Thread(()->{
           try{
               for (int i = 0; i < 6; i++) {
                   queue.put(i);
                   Thread.sleep(100);
                   System.out.println("added "+i);
               }
           }catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
        });

        Thread t2 = new Thread(()->{
            try{
                for (int i = 0; i < 6; i++) {
                    int j =queue.take();
                    Thread.sleep(100);
                    System.out.println("taken "+j);
                }
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

t1.start();
t2.start();

    }
}