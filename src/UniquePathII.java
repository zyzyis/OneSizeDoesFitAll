public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return 0;
            
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;
            
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i ++)
            grid[i] = new int[n];
        grid[0][0] = 1;    
        for (int i = 0; i < m + n; i ++) {
            for (int j = 0; j <= i; j++) {
                int y = j;
                int x = i - j;
                if (y >= m || x >= n || obstacleGrid[y][x] == 1)
                    continue;
                if (y - 1 >= 0 && obstacleGrid[y - 1][x] != 1)
                    grid[y][x] += grid[y - 1][x];
                if (x - 1 >= 0 && obstacleGrid[y][x - 1] != 1)
                    grid[y][x] += grid[y][x - 1];
            }
        }
        return grid[m - 1][n - 1];
    }
}