package assignments;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Average {
    public static void main(String[] args) {
        System.out.println(averageNum(1,2,3));
    }
//    In a program, input 3 numbers : compute the average of three numbers
    private static double averageNum(int a, int b,int c){
        return (a+b+c)/3;
    }

    //Problem Statement:
    //Given an array nums of n integers, return an array of all the unique
    //quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
    public static class Quadruplets {
        public static void main(String[] args) {
            System.out.println(Arrays.toString(quadSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2}, 10)));
            System.out.println(Arrays.toString(quadSum(new int[]{1, 2, 8, 7, 6, 5, 4, 3, 2}, 24)));
            System.out.println(Arrays.toString(quadSum(new int[]{1, 2, 3, 4, 5, 6, 7, 4, 3, 2}, 18)));
            System.out.println(Arrays.toString(quadSum(new int[]{1, 2, 3, 4, 4, 3, 2}, 25)));
        }
    // this is the brute force approach for the problem
    // so we re using 3 loops and in the 3rd loop we the hashset to store the value need. and return if the quadSUm is found
        private static int[] quadSum(int[] arr, int target) {
            int[] result = new int[4];
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    Set<Integer> last = new HashSet<>();
                    for (int k = j + 1; k < arr.length; k++) {
                        int need = target - (arr[i] + arr[j] + arr[k]);

                        if (last.contains(need)) {
                            System.out.println(need);
                            return new int[]{arr[i], arr[j], arr[k], need};

                        }
                        last.add(arr[k]);
                    }
                }
            }
            return new int[]{-1, -1, -1, -1};
        }
    }
}
