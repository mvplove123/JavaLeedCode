package amazon.medium;

/**
 * 240 Created by admin on 2018/3/8.
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p/>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example,
 * <p/>
 * Consider the following matrix:
 * <p/>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * <p/>
 * Given target = 20, return false.
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {

        //判断矩阵边界条件
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        //行的长度和列的长度
        int row = 0;
        int col = matrix[0].length - 1;

        //从矩阵尾部最后一列循环
        while (col >= 0 && row <= matrix.length - 1) {

            //相等则返回true
            if (target == matrix[row][col]) {
                return true;
                //目标值大于当前值，则行数加1，目标值在行数下侧,因为行数和列数都是有序的
            } else if (target > matrix[row][col]) {
                row++;
                //目标值小于当前值，则列数减1，目标值在列数的左侧
            } else {
                col--;
            }

        }
        return false;

    }
}
