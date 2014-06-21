public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return false;
            
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i += 3) {
            for (int j = 0; j < n; j += 3) {
                boolean[] mark = new boolean[10];
                for (int k = i; k < i + 3; k ++)
                    for (int l = j; l < j + 3; l ++) {
                        if (board[k][l] == '.')
                            continue;                    
                        int v = board[k][l] - '0';
                        if (mark[v])
                            return false;
                        mark[v] = true;
                    }
            }
        }
        
        for (int i = 0; i < m; i ++) {
            boolean[] mark = new boolean[10];
            for (int j = 0; j < n; j ++) {
                if (board[i][j] == '.')
                    continue;                    

                int v = board[i][j] - '0';
                if (mark[v])
                    return false;
                mark[v] = true;
            }
        }

        for (int i = 0; i < m; i ++) {
            boolean[] mark = new boolean[10];
            for (int j = 0; j < n; j ++) {
                if (board[j][i] == '.')
                    continue;                    

                int v = board[j][i] - '0';
                if (mark[v])
                    return false;
                mark[v] = true;
            }
        }

        return true;
    }
}