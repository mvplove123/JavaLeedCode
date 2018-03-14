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

        //�жϾ���߽�����
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        //�еĳ��Ⱥ��еĳ���
        int row = 0;
        int col = matrix[0].length - 1;

        //�Ӿ���β�����һ��ѭ��
        while (col >= 0 && row <= matrix.length - 1) {

            //����򷵻�true
            if (target == matrix[row][col]) {
                return true;
                //Ŀ��ֵ���ڵ�ǰֵ����������1��Ŀ��ֵ�������²�,��Ϊ�������������������
            } else if (target > matrix[row][col]) {
                row++;
                //Ŀ��ֵС�ڵ�ǰֵ����������1��Ŀ��ֵ�����������
            } else {
                col--;
            }

        }
        return false;

    }
}
