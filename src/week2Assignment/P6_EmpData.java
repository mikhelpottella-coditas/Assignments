package week2Assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class P6_EmpData {
    public static void main(String[] args) {
        ArrayList<String > employees = new ArrayList<>(Arrays.asList("michael","swaraj","lufy","Anil")); // creating a arralist to store the names
        System.out.println("this is the order as input\n");
        employees.forEach(emp-> System.out.println(emp));

        System.out.println("these are start with 'A'\n");
        employees.stream().filter((emp)-> emp.toUpperCase().startsWith("A"));

        employees.sort(null);
        System.out.println("this are sorted according to the alphabetical order\n");
        employees.forEach(emp-> System.out.println(emp));



    }
}
