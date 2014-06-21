public class Solution {
    private ArrayList<String[]> result = new ArrayList<String[]>();
    public ArrayList<String[]> solveNQueens(int n) {
        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i ++)
            matrix[i] = new int[n];
            
        go(matrix, 0, n);
        return result;        
    }

    private void go(int[][] matrix, int row, int total) {
        if (row == total) {
            String[] tmp = new String[total];
            for (int i = 0; i < total; i ++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < total; j ++) {
                    if (matrix[i][j] == 1)
                        builder.append('Q');
                    else
                        builder.append('.');
                }
                tmp[i] = builder.toString();
            }
            result.add(tmp);
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