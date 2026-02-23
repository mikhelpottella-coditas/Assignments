package Week4AssignmentQuestions;

//        Write a program that demonstrates the use of a sequenced map to iterate over the
//        entries in both insertion and reverse order.

import java.util.LinkedHashMap;
import java.util.SequencedMap;

public class P10_Map {
    static void main() {
        SequencedMap map = new LinkedHashMap(); // creating the sequenced map
        map.putFirst(1,"hello"); //  adding data from the first

        map.putLast(2,"hi");  //  adding data from the last

        System.out.println(map.firstEntry()); // accessing the data with first entry
        System.out.println(map.lastEntry());  // accessing the data with the last entry

    }
}


// output:
//
//    1=hello
//    2=hi