//package handsOn.threading;
//
//// Online Java Compiler
//// Use this editor to write, compile and run your Java code online
////There is a class Employee
//// Write a program using lambda expressions to perform the following operations:
//// Sort employees by salary in descending order.
//// Increase the salary of all employees by 10%.
//
//import java.util.*;
//import java.util.concurrent.Executor;
//import java.util.concurrent.ExecutorService;
//
//class Main {
//    public static void main(String[] args) {
//        ArrayList<Employee> Employees = new ArrayList<>();
//        Employees.add(new Employee("sagar",70000));
//        Employees.add(new Employee("michale",30000));
//        Employees.add(new Employee("lufi",10000));
//        Employees.add(new Employee("joro",90000));
//        Employees.add(new Employee("sag",7000));
//
//        Employees.forEach((Employee emp)->System.out.println(emp.name+" "+emp.salary));
//        // Collections.sort(Employees,compareTo((Employee e1,Employee e2)->e1.salary - e2.salary));
//
//        Employees.forEach((Employee e1)->e1.salary+=e1.salary+(e1.salary/10));
//        Employees.forEach((Employee emp)->System.out.println(emp.name+ " "+emp.salary));
//
//        ExecutorService
//    }
//}
//
//class Employee{
//    String name;
//    double salary;
//
//    public Employee(String name,double salary){
//        this.name = name;
//        this.salary = salary;
//    }
//
//}
