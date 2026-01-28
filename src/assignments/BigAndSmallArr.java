package assignments;

import java.util.Arrays;

public class BigAndSmallArr {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxAndMinArr(new int[]{4,5,6,3,6,4,7,})));
        System.out.println(Arrays.toString(maxAndMinArr(new int[]{85,8,4,7,83,56,566,34})));
        System.out.println(Arrays.toString(maxAndMinArr(new int[]{0,89,-65,-8,7,2})));
        System.out.println(Arrays.toString(maxAndMinArr(new int[]{1,45634,535,8785,24,-3453})));

        System.out.println(Arrays.toString(maxAndMinArr(new int[]{1, 2, 4, 6, 7, 8})));
    }

    private static int[] maxAndMinArr(int[] arr){
        int max =0;
        int min =987654321;
        for(int i:arr){
            if(i>max)max=i;
            if(i<min)min=i;
        }
        return new int[]{max,min};
    }
}
