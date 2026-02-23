package Week4AssignmentQuestions;

//    Create a sequenced set and demonstrate iterating over the set in forward and reverse
//    order


import java.util.LinkedHashSet;
import java.util.SequencedSet;

public class P9_set {

    static void main() {
        SequencedSet set = new LinkedHashSet();

        set.addFirst(20); // adding ele ment in first
        set.addLast(30); //  adding ele ment last
        set.addLast(20);      // changing the loc of 20 from first to last

        System.out.println(set.getFirst());  //  reading ele from first

    }

}
