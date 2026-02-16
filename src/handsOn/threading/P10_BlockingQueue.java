package handsOn.threading;

//    Problem : You are required to implement a Producer-Consumer system using two
//            threads. The Producer thread should generate items (in this case, integers) and the
//            Consumer thread should consume these items. The producer should wait if the buffer
//            (queue) is full, and the consumer should wait if the buffer is empty.


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class P10_BlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> shop = new ArrayBlockingQueue<>(5); // using the blocking queue so it can auto handle the wait and notify
        int capacity = 10;

        new Thread(()->{ // thread that acts as a producer
            try{
                for (int i = 0; i < capacity; i++) {
                    shop.put(i);
                    System.out.println("adding stock no."+ i);

                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(()->{ //  thread that acts as a consumer
            try{
                for (int i = 0; i < capacity; i++) {
                    shop.take();
                    System.out.println("consuming stock no."+ i);
                    Thread.sleep(3000);
                    System.out.println("consumed stock no."+i);

                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}


/** output:
 adding stock no.0
 adding stock no.1
 consuming stock no.0
 adding stock no.2
 adding stock no.3
 adding stock no.4
 adding stock no.5
 consumed stock no.0
 consuming stock no.1
 adding stock no.6
 consumed stock no.1
 adding stock no.7
 consuming stock no.2
 consumed stock no.2
 adding stock no.8
 consuming stock no.3
 consumed stock no.3
 consuming stock no.4
 adding stock no.9
 consumed stock no.4
 consuming stock no.5
 consumed stock no.5
 consuming stock no.6
 consumed stock no.6
 consuming stock no.7
 consumed stock no.7
 consuming stock no.8
 consumed stock no.8
 consuming stock no.9
 consumed stock no.9

 */
