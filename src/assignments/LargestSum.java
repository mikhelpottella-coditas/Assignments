package assignments;

public class LargestSum {
    public static void main(String[] args) {
//        Given an integer array nums, find the subarray with the largest sum,
//            and return its sum
        System.out.println(maxSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 4));
    }

    private static long maxSum(int[] arr, int subLen) {

        // the idea is to find the big number and to store it in the variable (Max) and in every itaration it changes and find the next max
        int max = 0;
        int maxSum = 0;
        for(int i=0;i<=arr.length-subLen;i++){
            for (int j = i; j < i+subLen; j++) {
                max+=arr[j];
                System.out.print(arr[j]);
            }
            System.out.println();
           if(max > maxSum) maxSum=max;
           max=0;
        }


        return maxSum;
    }
}
