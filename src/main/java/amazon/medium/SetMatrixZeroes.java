package amazon.medium;

/**
 * 73. Set Matrix Zeroes
 * Created by admin on 2018/3/15.
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * <p/>
 * click to show follow up.
 * <p/>
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * <p/>
 */

public class SetMatrixZeroes {
    /**
     * [
     * [1, 0, 1, 1],
     * [1, 1, 0, 0],
     * [0, 1, 1, 1],
     * [1, 1, 1, 1]
     * ]
     * time : O(n * m)
     * space : O(1)
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        //�жϱ߽�
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        boolean col = false;
        boolean row = false;
        //ѭ��ÿ����
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //��ǰ��Ϊ0
                if (matrix[i][j] == 0) {
                    //�õ�����ף�������Ϊ0
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    //�õ㴦�ڵ�0�У�������row true
                    if (i == 0) {
                        row = true;
                    }
                    //�õ㴦�ڵ�0�У�������col true
                    if (j == 0) {
                        col = true;
                    }
                }
            }
        }
        //�ӵ�һ�п�ʼ��������е�����Ϊ0���Ͱ�ͬ�е������ж���Ϊ0
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //�ӵ�һ�п�ʼ��������е�����Ϊ0���Ͱ�ͬ�е������ж���Ϊ0
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //�Ե�0�е������ж���Ϊ0
        if (row) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        //�Ե�0�е������ж���Ϊ0
        if (col) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
