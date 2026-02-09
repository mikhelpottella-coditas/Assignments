package evaluationWeek2;

import java.io.File;

public class BookData {

    static File getBookmethod() {
        try {
            File bookfile = new File("src/evaluationWeek2/bookfile.txt");
            return bookfile;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
