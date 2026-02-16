package handsOn;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

class StringPractice
{
      public static void main(String[] args)
    {
        String s = "    Sachin   hi     ";

        // concat() method appends the string at the end
//        int newString = s.chars();
// Source - https://stackoverflow.com/a/22436638
// Posted by skiwi
// Retrieved 2026-02-16, License - CC BY-SA 3.0

        String a =  s.strip();

        // This will print Sachin because strings are immutable objects
        System.out.println(a);

    }
}