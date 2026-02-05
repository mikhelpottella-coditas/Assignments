package HandsOn;

public class A {
    static int a =10;

    public static void useObject(){
        System.out.println("called");
    }
}

class B{
    public static void main(String[] args) {

    }

    public void useVariable(){
        A obj = new A();
        System.out.println(obj.a);
        obj.useObject();
    }

    public  void use(){
        this.useVariable();
    }

}