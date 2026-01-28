package assignments;

import java.util.HashMap;

public class CompressString {
    public static void main(String[] args) {

//        Compress a string in the below format
        System.out.println(compress("helloeeoo"));
        System.out.println(compress("mikeyyyyy"));

    }

    private static String compress(String str){
        HashMap<Character,Integer> counter = new HashMap<>();
        for(char ch:str.toCharArray()){
            if(counter.containsKey(ch)) counter.put(ch,counter.get(ch)+1);
            else  counter.put(ch,1);
        }
        StringBuilder result = new StringBuilder();
        counter.forEach((key,value)->{
            result.append(key).append(value).append(" ");
        });
        return result.toString();
    }
}
