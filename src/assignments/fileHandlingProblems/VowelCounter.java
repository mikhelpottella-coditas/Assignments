package assignments.fileHandlingProblems;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//the idea is to read the file. every time you get a line run a charArray and check each char is vowel or not
// if it is vowel use the variable "Count" to count the vowels in the text file.

public class VowelCounter {
    public static void main(String[] args) {
        int count =0;

        try {
            File file = new File("src/assignments/fileHandlingProblems/vowel.txt");
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String data = read.nextLine();
                System.out.println(data);
                for(char i: data.toCharArray()){
                    if("AEIOUaeiou".indexOf(i)!=-1) count++;
                }

            }
            read.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(count);
    }
}
