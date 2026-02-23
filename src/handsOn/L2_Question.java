package handsOn;
//You are given a 2D integer matrix of size m x n.
//
//Your task is to calculate the sum of all boundary
//elements of the matrix.
//
//Boundary elements include:
//First row
//Last row
//First column
//Last column
//
//IMPORTANT:
//Do not count any element more than once.
//
//----------------------------------------------------
//FUNCTION SIGNATURE
//----------------------------------------------------
//
//public static int boundarySum(int[][] matrix)
//
//----------------------------------------------------
//EXAMPLE 1
//----------------------------------------------------
//
//Input:
//
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12],
//  [13,14,15,16]
//]
//
//Boundary elements:
//1, 2, 3, 4,
//8, 12,
//13,14,15,16,
//9, 5
//
//Sum = 1+2+3+4+8+12+13+14+15+16+9+5 = 102
//
//Output:
//102
public class L2_Question {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12},
                {13,14,15,16}};

        int sum=0;
        for(int i=0;i<array.length;i++){
            sum+=array[i][0];
        }
        for (int i = 1; i <array.length ; i++) {

            sum+=array[array.length-1][i];
        }
        for (int i = array.length-2; i >= 0; i--) {
            sum+=array[i][array.length-1];

        }for (int i = array.length-2; i > 0; i--) {
            sum+=array[0][i];

        }
        System.out.println(sum);
    }
}
