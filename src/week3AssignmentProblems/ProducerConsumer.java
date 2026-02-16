package week3AssignmentProblems;

import java.util.concurrent.ArrayBlockingQueue;


//    . Problem : You are required to implement a Producer-Consumer system using two
//    threads. The Producer thread should generate items (in this case, integers) and the
//    Consumer thread should consume these items. The producer should wait if the buffer
//            (queue) is full, and the consumer should wait if the buffer is empty.

public class ProducerConsumer {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);  // creating a Blocking queue with capacity 1.

        Thread t1 = new Thread(()->{  // acts as a producer and add items into the queue
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

        Thread t2 = new Thread(()->{ // acts as a consumer and remove items
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


// output:
//   "C:\Program Files\Java\jdk-17\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2025.3.2\lib\idea_rt.jar=63159" -Dfile.encoding=UTF-8 -classpath C:\Users\Coditas-Admin\IdeaProjects\JavaBeginnersCourse\out\production\JavaBeginnersCourse week3AssignmentProblems.ProducerConsumer
//added 0
//taken 0
//added 1
//taken 1
//taken 2
//added 2
//taken 3
//added 3
//added 4
//taken 4
//taken 5
//added 5