//package HandsOn;
///*
//* Write a Java program to create an abstract class GeometricShape with abstract methods area()
//* and perimeter(). Create subclasses Triangle and Square that extend the GeometricShape class and
//* implement the respective methods to calculate the area and perimeter of each shape.
//* */
//abstract class GeometricShape { // i understand that the abstract class can only be public or default
//    abstract int area(int a,int b,int c);
//    abstract int perimeter(int a, int b,int c);
//}
//
//final class Triangle extends GeometricShape{
//
//
//    @Override
//    int area(int a,int b,int c) {
//        return a*b*c;
//    }
//
//
//    @Override
//    int perimeter(int a,int b,int c) {
//        return a+b+c;
//    }
//}
//class Square extends GeometricShape{
//
//    @Override
//    int area(int a,int b,int c) {
//        return a*b*c;
//    }
//
//    @Override
//    int perimeter(int a,int b,int c) {
//        return a+b+c;
//    }
//
//    public static void main(String[] args) { // the main always have to return void otherwise the compiler don't know it
//        GeometricShape shape = new Square();
//        System.out.println(shape.area(4,5,4));
//        inner in = new inner();
////        in.a+=12  here we can not modify the data because the interface make it final by defau    lt;
//        in.method();
//    }
//
//    void display(){
//        System.out.println("helo");
//    }
//}
//
//interface inter {
//    int a =10;
//    default void method(){
//        System.out.println("hi");
//    }
//}
//
//class inter2{
//    int a=10;
//    void method(){
//        System.out.println("hi");
//    }
//
//}
//final class Hello{
//      class Hi{
//
//        }
//}
