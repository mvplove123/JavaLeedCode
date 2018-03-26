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
        //判断边界
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        boolean col = false;
        boolean row = false;
        //循环每个点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //当前点为0
                if (matrix[i][j] == 0) {
                    //该点的行首，列首置为0
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    //该点处于第0行，则设置row true
                    if (i == 0) {
                        row = true;
                    }
                    //该点处于第0列，则设置col true
                    if (j == 0) {
                        col = true;
                    }
                }
            }
        }
        //从第一行开始，如果该行的首列为0，就把同行的其他列都置为0
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //从第一列开始，如果该列的首行为0，就把同列的其他行都置为0
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //对第0行的所有列都置为0
        if (row) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        //对第0列的所有行都置为0
        if (col) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
