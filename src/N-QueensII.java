public class Solution {
    private int result = 0;
    public int totalNQueens(int n) {
        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i ++)
            matrix[i] = new int[n];
            
        go(matrix, 0, n);
        return result;
    }
    
    private void go(int[][] matrix, int row, int total) {
        if (row == total) {
            result ++;
            return;
        }
        
        for (int i = 0; i < total; i ++) {
            if (isGood(matrix, row, i, total)) {
                matrix[row][i] = 1;
                go(matrix, row + 1, total);
                matrix[row][i] = 0;
            }
        }
    }
    
    private boolean isGood(int[][] matrix, int row, int column, int n) {
        for (int i = 0; i < row; i ++)
            if (matrix[i][column] == 1)
                return false;

        for (int i = 0; i < row; i ++) {
            int y = row - i - 1;
            int x = column - 1 - i;
            if (x < 0)
                break;
            if (matrix[y][x] == 1)
                return false;
        }
        
        for (int i = 0; i < row; i ++) {
            int y = row - i - 1;
            int x = column + 1 + i;
            if (x >= n)
                break;
            if (matrix[y][x] == 1)
                return false;
        }
        return true;
    }
}