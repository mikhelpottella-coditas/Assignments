package handsOn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class L1Question {
    public static void main(String[] args) {
        String word = "hello michaeldbn i am ";
        // lets try 2 pointer approach

        String presentWord="";
        String maxWord="";
        int i=0;
        int j=0;
        while(i<word.length()){
//            System.out.println(word.charAt(i));
            if(!(presentWord.contains(""+word.charAt(i)))){
                presentWord+=""+word.charAt(i);
                i++;
            }
            else{
                if(presentWord.length()>maxWord.length()) maxWord=presentWord;
                presentWord="";
                j++;
                i=j;
            }

        }
        if(presentWord.length()>maxWord.length()) maxWord=presentWord;
        System.out.println(maxWord);

    }
}


