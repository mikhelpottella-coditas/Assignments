package assignments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

// problem statement:
//Given an array of intervals where intervals[i] = [starti, endi], merge all
//overlapping intervals, and return an array of the non-overlapping
//intervals that cover all the intervals in the input.
public class Intervels {

    public static void main(String[] args) {
        int[][] result = compress(new int[][]{{1, 2}, {5, 6}, {8, 10}});
//        {{1, 5}, {2, 6}, {5, 10}, {7, 12}},
//        {{1, 10}, {2, 5}, {6, 7}},
//        {{1, 2}, {5, 6}, {8, 10}},
//        {{1, 5}, {5, 10}},
//        {{10, 15}, {1, 3}}
        for(int[] i: result){
            System.out.print("  "+Arrays.toString(i));
        }
    }

    private static int[][] compress(int[][] arr){
//    Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
//        ArrayList after = new ArrayList<>();
//        for(int i=0;i<arr.length-1;i++) {
//            System.out.println(Arrays.toString(arr[i]));
//            if(arr[i][1]<arr[i+1][0]) {
//                after.add(arr[i]);
//                after.add(arr[i+1]);
//            }
//            else if(arr[i][1]>arr[i+1][1]){
//                int min = 0;
//                if(arr[i][0]<arr[i+1][0]) min = arr[i][0];
//                else min = arr[i+1][0];
//                after.add(new int[]{min, arr[i][1]});
//            }
//            else{
//
//                int min = 0;
//                if(arr[i][0]<arr[i+1][0]) min = arr[i][0];
//                else min = arr[i+1][0];
//                after.add(new int[]{min,arr[i+1][1]});
//
//            }
//
//
//        }
//
//        return after;

        if (arr.length <= 1) return arr;

        // 1. Sort by start time
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        // 2. Use a LinkedList to easily access the 'last' element
        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] current : arr) {
            // If list is empty or no overlap with the LAST merged interval
            if (merged.isEmpty() || merged.getLast()[1] < current[0]) {
                merged.add(current);
            }
            // If there is an overlap, merge by updating the end time
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], current[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
