package Week4AssignmentQuestions;

//    Write a record class to represent a Person with fields name and age, and demonstrate
//    its usage.


record  Preson(String name, int age) {}

public class P5_RecordClass {
    public static void main(String[] args) {
        // we are goint to call the constructor with out creating one
        Preson person = new Preson("Michael",21);

        // lets use getter without careatng one
        System.out.println(person.age());
        System.out.println(person.name());

        // lets call the overridden toString
        System.out.println(person.toString());
    }
}


/*

output:

21
Michael
Preson[name=Michael, age=21]
* */