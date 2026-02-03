package week2Assignment;

import java.util.Arrays;


// problem statement:
/*Write a program to prove that Java follows pass by value: -
• Pass a primitive variable to a method and modify it.
• Pass an object to a method and modify its internal state.
• Print values before and after method calls.
* */

public class P5_ValuePassing {
    public static void main(String[] args) {
        int a = 5; // initialized a primitive variable.

        System.out.println("primitive From main before method call: "+a);

        primitive(a);

        System.out.println("primitive From main after method call: "+a);

        // now lets try on object.

        int [] array = new int[]{1,2,3,};
        System.out.println("Object From main before method call: "+Arrays.toString(array));
        object(array);
        System.out.println("Object From main after method call: "+Arrays.toString(array));

    }
    static void primitive(int a){
        System.out.println("primitive From method before change: "+a);

        a+=5;
        System.out.println("primitive From method after change: "+a);

    }

    static  void object(int[] array){
        System.out.println("object From method before change: "+ Arrays.toString(array));
        array = new int[]{11,12,23};
        System.out.println("object From method after change: "+Arrays.toString(array));

    }
}
