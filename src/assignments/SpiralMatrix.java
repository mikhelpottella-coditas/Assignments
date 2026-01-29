package assignments;

import java.util.Arrays;

public class SpiralMatrix {
    public static void main(String[] args) {
//        int[][] arr = {
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16}
//        };
//        int top = 0;
//        int right = arr[0].length-1;
//        int left = 0;
//        int bottom = arr.length-1;
//
//        while(top<=bottom && left<=right){
////            left to right
//            for(int i = left ;i<=right;i++){
//                System.out.println(arr[top][i]);
//            }
//            top++;
////            top to bottom
//            for(int i = top;i<=bottom;i++){
//                System.out.println(arr[i][right]);
//            }
//            right--;
////            right to left
//            for(int i = right;i>=left;i--){
//                System.out.println(arr[right][i]);
//            }
//            bottom++;
//
//            //bottom to top
//            for(int i=bottom;i>=top;i--){
//                System.out.println(arr[i][left]);
//            }
//
//        }

        System.out.println( Arrays.toString(spiral(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}} )));
    }

    private static int[] spiral(int[][] arr){
        int istart=0;
        int jstart = 0;
        int iend=arr.length-1;
        int jend = arr.length-1;
        System.out.println(arr.length);
        int[] result = new int[arr.length*arr.length];
        int storeIndex =0;
        //let move to top right
        while(istart<=iend||jstart<=jend) {

            for (int i = jstart; i <= jend; i++) {
                result[storeIndex] = arr[istart][i];
                storeIndex++;
            }
                    istart++;
               //lets move right bottom
            for (int i = istart; i <= iend; i++) {
                result[storeIndex] = arr[i][jend];
                storeIndex++;
            }
                    jend--;
            //lets move bottom left
            for (int i = jend; i >= jstart; i--) {
                result[storeIndex] = arr[iend][i];
                storeIndex++;
            }
                    iend--;

            //lets move left top

            for (int i = iend; i >= istart; i--) {
                result[storeIndex] = arr[i][jstart];
                storeIndex++;
            }
                    jstart++;

        }

        return result;
    }
}
