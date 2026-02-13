package week3AssignmentProblems;

// Problem statement :
/*
 *       Problem: Create a program that simulates a race between 3 runners, each represented
 *       by a separate thread. The threads should start at the same time and print their progress
 *       in intervals. The race ends when the first runner completes a fixed number of steps.
 *
 *      Objective: Understand how to start threads and manage their lifecycle using Thread
 *       class or Runnable interface.
 * */


// Idea:
// the core idea is to create a static flag variable for the class
// and to stop all the threads when every one thread reaches to end.


class Race extends Thread { // this class extends is used to create multiple threads
    static boolean flag = false; // the static variable to be used for all same the thread.

    @Override
    public void run() {
        letsRun();

    }


    // this is the method to stimulate race.
    void letsRun() {
        for (int i = 1; i <= 10; i++) {
            if (flag) break; // since flag is static even one thread change it ll remain threads stop

            System.out.println(Thread.currentThread().getName() + " made this many steps" + i);
            if (i == 10) {
                System.out.println("the winner is " + Thread.currentThread().getName());
                flag = true;
                break;
            }
            try {
                Thread.sleep((long) (Math.random() * 1000)); // the random method is used to make the real runners kind of feel. the pace change.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

public class P1_Race {
    public static void main(String[] args) {
        Race racer1 = new Race();
        Race racer2 = new Race();
        Race racer3 = new Race();
        racer1.setName("michael");
        racer2.setName("swaraj");
        racer3.setName("Lufy");

        racer1.start();
        racer2.start();
        racer3.start();

    }
}


// out put:

/*
swaraj made this many steps1
michael made this many steps1
Lufy made this many steps1
Lufy made this many steps2
Lufy made this many steps3
Lufy made this many steps4
swaraj made this many steps2
michael made this many steps2
swaraj made this many steps3
Lufy made this many steps5
michael made this many steps3
swaraj made this many steps4
Lufy made this many steps6
michael made this many steps4
swaraj made this many steps5
Lufy made this many steps7
michael made this many steps5
swaraj made this many steps6
swaraj made this many steps7
Lufy made this many steps8
michael made this many steps6
swaraj made this many steps8
Lufy made this many steps9
Lufy made this many steps10
the winner is Lufy


*/