package evaluationWeek2;

import java.io.File;

public class BookData {

    static File bookmethod() {
        try {
            File bookfile = new File("src/bookfile.txt");
            return bookfile;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
