package assignments;

import java.util.Arrays;

public class DutchFlag {
    public static void main(String[] args) {
        System.out.println("1st test : "+Arrays.toString(dutch(new String[]{"red","red","white","blue","blue","white","red","red","white","blue","blue","white"})));
        System.out.println("2st test : "+Arrays.toString(dutch(new String[]{"red","red","red","red","white","blue","blue","white"})));
        System.out.println("3st test : "+Arrays.toString(dutch(new String[]{"red","red","white","blue","blue","white","blue","blue","white"})));
    }
    private static String[] dutch(String[] arr){
        int start = 0;
        int end = arr.length-1;
        int mid = 0;
        System.out.println(mid+" "+end+Arrays.toString(arr)+" lenth"+arr.length);
        while(mid<=end){

            if(arr[mid].equals("red")){
                String tem = arr[mid];
                arr[mid] = arr[start];
                arr[start] = tem;
                mid++;
                start++;
            }
            else if(arr[mid].equals("white")) mid++;

            else if (arr[mid].equals("blue")) {
                String tem = arr[mid];
                arr[mid] = arr[end];
                arr[end] = tem;
                end--;
            }

        }
        return arr;
    }
}
