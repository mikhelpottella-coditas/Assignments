package assignments;
import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1,2,3},          4   )));
        System.out.println(Arrays.toString(twoSum(new int[]{1234,5678,9012}, 14690)));
        System.out.println(Arrays.toString(twoSum(new int[]{2,2,3},          4)));
        System.out.println(Arrays.toString(twoSum(new int[]{2,3,1},          4)));
    }

        public static int[] twoSum(int[] numbers, int target) {
//       Arrays.sort(numbers);
//       int i = 0;
//       int j = numbers.length-1;
//       while(i<j){
//         int adder = numbers[i]+numbers[j];
//         if(adder<target) i++;
//         else if(adder>target) j--;
//         else if (adder==target) return new int[]{i,j};
//       }
//       return new int[]{-1,-1};

            for(int i=0;i<numbers.length;i++){
                for(int j=0;j<numbers.length;j++){
                    if(i==j) continue;
                    if(numbers[i]+numbers[j] == target) return new int[]{i,j};
                }

            }
            return new int[]{-1,-1};
        }

}
