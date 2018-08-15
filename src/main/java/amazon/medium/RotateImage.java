package amazon.medium;

/**
 * 48. Rotate Image
 * Created by admin on 2018/3/15.
 * You are given an n x n 2D matrix representing an image.
 * <p/>
 * Rotate the image by 90 degrees (clockwise).
 * <p/>
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT
 * allocate another 2D matrix and do the rotation.
 * <p/>
 * Example 1:
 * <p/>
 * Given input matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p/>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * Example 2:
 * <p/>
 * Given input matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p/>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 *
 * 先按照对角线互换值，然后在左右对称互换值
 */
public class RotateImage {

    public void rotate(int[][] matrix) {

        //行数，列数
        int rows = matrix.length;
        int cols = matrix[0].length;

        //对角线交换
        for(int i=0;i<rows;i++){
            //这步重点，j=i
            for(int j=i;j<cols;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        //左右交换
        for(int i=0;i<rows;i++){
            for(int j=0;j<rows/2;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[i][rows-1-j];
                matrix[i][rows-1-j]=temp;
            }
        }
    }

}
