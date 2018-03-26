package amazon.medium;

/**
 * 200 Created by admin on 2018/2/6.
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid
 * are all surrounded by water.
 * <p/>
 * Example 1:
 * <p/>
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * <p/>
 * Example 2:
 * <p/>
 * 11000
 * 11000
 * 00100
 * 00011
 * <p/>
 * time : O(m * n)
 * space : O(n)
 * �ǳ���Ҫ�����㣺BFS,DFS
 */
public class NumberOfIslands {

    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        //�߽��ж�
        int res = 0;
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //����
        m = grid.length;
        //����
        n = grid[0].length;
        //ѭ������
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //����Ϊ1�������dfs,������ȱ���
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        //�߽��жϣ����в���С��0������Խ�磬��ǰֵ����Ϊ0
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') {
            return;
        }
        //�Ե�ǰֵ����Ϊ0
        grid[i][j] = '0';
        //�Ըõ���������Ҷ����еݹ���ң�����Ϊ0
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
    }

    public int numIslands2(char[][] grid) {
        //�߽��ж�
        int res = 0;
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //����
        m = grid.length;
        //����
        n = grid[0].length;
        //ѭ������
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //����Ϊ1�������dfs,������ȱ���
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }
    private void bfs(char[][] grid, int x, int y){

    }
}
