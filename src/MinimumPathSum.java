public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
            
        int m = grid.length;
        int n = grid[0].length;
        int[][] cost = new int[m][];
        for (int i = 0; i < m; i ++)
            cost[i] = new int[n];        
        cost[m - 1][n - 1] = grid[m - 1][n - 1];
        for (int i = 0; i < m + n; i ++) {
            for (int j = 0; j <= i; j ++) {
                int ni = Math.max(m - j - 1, 0);
                int nj = Math.max(n - i + j - 1 , 0);

                if (ni < m - 1 && nj < n - 1)
                    cost[ni][nj] = Math.min(
                        cost[ni + 1][nj] + grid[ni][nj],
                        cost[ni][nj + 1] + grid[ni][nj]
                    );
                else if (nj < n - 1)
                    cost[ni][nj] = cost[ni][nj + 1] + grid[ni][nj];
                else if (ni < m - 1)
                    cost[ni][nj] = cost[ni + 1][nj] + grid[ni][nj];
            }
        }
        return cost[0][0];
    }
}