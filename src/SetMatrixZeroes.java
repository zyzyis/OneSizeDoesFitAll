public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0)
            return;
            
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i ++)
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < m; k ++)
                        if (matrix[k][j] != 0)
                            matrix[k][j] = Integer.MIN_VALUE + 1;
                    for (int k = 0; k < n; k++)
                        if (matrix[i][k] != 0)
                            matrix[i][k] = Integer.MIN_VALUE + 1;
                }
            }
        
        for (int i = 0; i < m; i ++)
            for (int j = 0; j < n; j ++)
                if (matrix[i][j] == Integer.MIN_VALUE + 1)
                    matrix[i][j] = 0;
    }
}