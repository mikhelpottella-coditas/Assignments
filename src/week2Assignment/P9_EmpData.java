package week2Assignment;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

//.Write a program to store employee ID and name using:-
//HashMap - LinkedHashMap - TreeMap
//Insert at least 5 entries in each map and print them.
//Observe and explain the ordering behavior of each map.
public class P9_EmpData {
    public static void main(String[] args) {

        // this is to hashmap
        HashMap<Integer,String> emplist = new HashMap<>();
        emplist.put(6,"michael");
        emplist.put(3,"swaraj");
        emplist.put(9,"lufy");
        emplist.put(1,"zoro");
        emplist.put(2,"harsh");
        emplist.forEach((id,name)-> System.out.println(id + " "+ emplist.get(id)));


        // this is the linked list
        LinkedHashMap<Integer,String> linkedEmplist = new LinkedHashMap<>();
        linkedEmplist.put(6,"michael");
        linkedEmplist.put(3,"swaraj");
        linkedEmplist.put(9,"lufy");
        linkedEmplist.put(1,"zoro");
        linkedEmplist.put(2,"harsh");
        linkedEmplist.forEach((id,name)-> System.out.println(id + " "+ linkedEmplist.get(id)));



        // this is the treemap
        TreeMap<Integer,String> treeEmpList = new TreeMap<>();
        treeEmpList.put(6,"michael");
        treeEmpList.put(3,"swaraj");
        treeEmpList.put(9,"lufy");
        treeEmpList.put(1,"zoro");
        treeEmpList.put(2,"harsh");
        treeEmpList.forEach((id,name)-> System.out.println(id + " "+ treeEmpList.get(id)));


    }
}
// so as we see that the treemap is arranged in
// the sorted order of id's and other 2 just following the input order