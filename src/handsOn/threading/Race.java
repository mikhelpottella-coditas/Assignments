package handsOn.threading;
//    Problem: Create a program that simulates a race between 3 runners, each represented
//    by a separate thread. The threads should start at the same time and print their progress
//    in intervals. The race ends when the first runner completes a fixed number of steps.
//    Objective: Understand how to start threads and manage their lifecycle using Thread
//    class or Runnable interface
    class racer implements Runnable{
       static boolean flag =false;
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                if(flag) break;
                System.out.println(Thread.currentThread().getName()+" is at "+i);
                try {
                    Thread.sleep((long) (Math.random()*1000) );
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(i==9){
                    flag = true;
                    System.out.println("race ended h winner is "+Thread.currentThread().getName());
                    break;
                }
            }

        }
    }

public class Race {
    public static void main(String[] args) {
        racer race1 = new racer();
        Thread r1 = new Thread(race1,"r1");
        Thread r2 = new Thread(new racer(),"r2");
        Thread r3 = new Thread(new racer(),"r3");
        r1.start();
        r2.start();
        r3.start();
    }
    }
