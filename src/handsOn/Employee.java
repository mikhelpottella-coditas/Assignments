package handsOn;

import java.util.ArrayList;
import java.util.List;

class Emp{
    String id;
    String name;
    double salary;

    public Emp(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

public class Employee {
    public static void main(String[] args) {
        List<Emp> empList = new ArrayList<>();
        empList.add(new Emp("01","micahel",49000));
        empList.add(new Emp("02","abid",50000));
        empList.add(new Emp("03","swaraj",51000));

        empList.forEach((emp -> {
            if(emp.salary>=50000) System.out.println(emp.id+" "+emp.name+" "+emp.salary);
        }));

    }


}
