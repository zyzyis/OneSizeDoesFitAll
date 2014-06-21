public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i ++)
            grid[i] = new int[n];
        grid[0][0] = 1;    
        for (int i = 0; i < m + n; i ++) {
            for (int j = 0; j <= i; j++) {
                int y = j;
                int x = i - j;
                if (y >= m || x>= n)
                    continue;
                if (y - 1 >= 0)
                    grid[y][x] += grid[y - 1][x];
                if (x - 1 >= 0)
                    grid[y][x] += grid[y][x - 1];
            }
        }
        return grid[m - 1][n - 1];
    }
}