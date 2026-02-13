package week3AssignmentProblems;




import java.util.concurrent.CountDownLatch;

class RaleyRace extends Thread{
    String name;
    CountDownLatch wait;
    CountDownLatch signal;

    RaleyRace(String name,CountDownLatch wait,CountDownLatch signal){
        this.name = name;
        this.wait = wait;
        this.signal = signal;
    }

    @Override
    public void run() {
        try {
            if (wait != null){
                wait.await();
            }

            System.out.println("the current runner: "+ name);
            Thread.sleep(3000);
            if(signal!=null){
                signal.countDown();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class P6_waitLatch {

    public static void main(String[] args) {
        CountDownLatch boton1 = new CountDownLatch(1);
        CountDownLatch boton2 = new CountDownLatch(1);

        Thread runner1 = new Thread(new RaleyRace("runner1",null,boton1));
        Thread runner2 = new Thread(new RaleyRace("runner2",boton1,boton2));
        Thread runner3 = new Thread(new RaleyRace("runner3",boton2,null));

        runner2.start();
        runner1.start();
        runner3.start();
    }

}


