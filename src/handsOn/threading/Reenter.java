package handsOn.threading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
public class Reenter {
    public static void main(String[] args) {
        Printer printer = new Printer();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{
                printer.printDocument(""+ finalI);
            }).start();
        }
    }
}


class Printer {
    private final ReentrantLock lock = new ReentrantLock(true);

    void printDocument(String name){
        try{
            if(lock.tryLock(10,TimeUnit.SECONDS)){
                try {
                    System.out.println("the "+name+" is started");
                    Thread.sleep(1000);
                    System.out.println(" the "+name +" is finished");
                } finally {

                lock.unlock();
                }
            }
            else{
                System.out.println("don't get printer "+ name);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
