package HandsOn;
//
//import java.io.*;
//
//class Demo implements Serializable {
//    public int a;
//    public String b;
//
//    public Demo(int a, String b) {
//        this.a = a;
//        this.b = b;
//    }
//}
//
//public class SerializationPractice {
//    public static void main(String[] args) {
//        Demo object = new Demo(1, "geeksforgeeks");
//        String filename = "file.ser";
//
//        // Serialization
//        try {
//            FileOutputStream file = new FileOutputStream(filename);
//            ObjectOutputStream out = new ObjectOutputStream(file);
//            out.writeObject(object);
//            out.close();
//            file.close();
//            System.out.println("Object has been serialized");
//
//        } catch (IOException ex) {
//            System.out.println("IOException is caught");
//        }
//
//        Demo object1 = null;
//
//        // Deserialization
//        try {
//            FileInputStream file = new FileInputStream(filename);
//            ObjectInputStream in = new ObjectInputStream(file);
//            object1 = (Demo) in.readObject();
//            in.close();
//            file.close();
//            System.out.println("Object has been deserialized");
//            System.out.println("a = " + object1.a);
//            System.out.println("b = " + object1.b);
//
//        } catch (IOException ex) {
//            System.out.println("IOException is caught");
//        } catch (ClassNotFoundException ex) {
//            System.out.println("ClassNotFoundException is caught");
//        }
//    }
//}

import java.io.*;
import java.util.concurrent.locks.Lock;

class Emp implements Serializable {
    private static final long serialVersionUID = 129348938L;
    transient int a;
    static int b;
   transient String name;
    int age;

    public Emp(String name, int age, int a, int b) {
        this.name = name;
        this.age = age;
        this.a = a;
        this.b = b;
    }
}

public class SerializationPractice{
    public static void printData(Emp object1) {
        System.out.println("name = " + object1.name);
        System.out.println("age = " + object1.age);
        System.out.println("a = " + object1.a);
        System.out.println("b = " + object1.b);
    }

    public static void main(String[] args) {
        Emp object = new Emp("ab", 20, 2, 1000);
        String filename = "shubham.txt";

        // Serialization
        try {
            // Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(object);
            out.close();
            file.close();
            System.out.println("Object has been serialized\nData before Deserialization.");
            printData(object);

            // Change static variable b
            object.b = 2000;

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        object = null;

        // Deserialization
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            object = (Emp) in.readObject();
            in.close();
            file.close();
            System.out.println("Object has been deserialized\nData after Deserialization.");
            printData(object);
            Lock

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }
}