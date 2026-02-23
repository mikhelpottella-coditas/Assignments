package Week4AssignmentQuestions;

//        Write a program that demonstrates usage of the sequenced collection to iterate over a
//        list in forward and reverse order

import java.util.ArrayList;
import java.util.SequencedCollection;

public class P8_Sequenced {
    static void main() {
    SequencedCollection list = new ArrayList();
        for (int i = 0; i < 10; i++) { // inserting data from back
            list.add(i);
            System.out.println(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println( list.removeFirst());  //  inserting data from first
        }

        for (int i = 0; i < 10; i++) {
            list.addFirst(i);  //  inserting data from first
        }






        for (int i = 0; i < 10; i++) {
            System.out.println( list.removeLast());  //  inserting data from first
        }

    }



}

//   output:
//            0
//            1
//            2
//            3
//            4
//            5
//            6
//            7
//            8
//            9
//            0
//            1
//            2
//            3
//            4
//            5
//            6
//            7
//            8
//            9
//            0
//            1
//            2
//            3
//            4
//            5
//            6
//            7
//            8
//            9
