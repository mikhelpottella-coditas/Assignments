package week2Assignment;


/*
*  Create a class Student with fields:-
• id
• name
• marks
• Store multiple Student objects in an ArrayList and:-
o Sort students by marks using Comparable
o Sort students by name using Comparator
o Print the sorted results
* */

import java.util.ArrayList;
import java.util.Collections;

class StudentMark implements Comparable<StudentMark>{
    int id;
    String name;
    int marks;

    public StudentMark(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(StudentMark o) {
        return o.marks-this.marks;
    }
}


public class P10_StudentDetails {
    public static void main(String[] args) {
        ArrayList<StudentMark> studentMarks = new ArrayList<>();
        studentMarks.add(new StudentMark(5,"micahel",93));
        studentMarks.add(new StudentMark(4,"lufy",73));
        studentMarks.add(new StudentMark(1,"zoro",43));
        studentMarks.add(new StudentMark(3,"sanji",83));

// here to print the data before sorting
        studentMarks.forEach((student)-> System.out.println(student.id+" "+student.name+" "+student.marks));

        System.out.println("\n\n");
        // this is to print after sorting by marks
        studentMarks.sort(null);
        studentMarks.forEach((student)-> System.out.println(student.id+" "+student.name+" "+student.marks));

        // this is to print after sorting by names
        System.out.println("\n\n");
        Collections.sort(studentMarks,(o1,o2)->o1.getName().compareTo(o2.getName()));
        studentMarks.forEach((student)-> System.out.println(student.id+" "+student.name+" "+student.marks));

    }
}


//out put:
//5 micahel 93
//4 lufy 73
//1 zoro 43
//3 sanji 83
//
//
//
//5 micahel 93
//3 sanji 83
//4 lufy 73
//1 zoro 43
//
//
//
//4 lufy 73
//5 micahel 93
//3 sanji 83
//1 zoro 43
