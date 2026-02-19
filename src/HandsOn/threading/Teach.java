package handsOn.threading;

class lthread implements Runnable{
    @Override
    public void run(){
        System.out.println("hi");
    }
}

public class Teach{
    public static void main(String[] args) {
        lthread th=new lthread();
        Thread lth=new Thread(th);
        lth.start();
        lth.getName();

    }

}