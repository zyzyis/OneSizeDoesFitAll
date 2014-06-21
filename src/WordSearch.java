public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null)
            return false;
            
        int m = board.length;
        int n = board[0].length;
        boolean result = false;
        boolean[][] mark = new boolean[m][];
        for (int i = 0; i < m; i ++)
            mark[i] = new boolean[n];
            
        for (int i = 0; i < m; i ++)
            for (int j = 0; j < n; j ++) {
                if (board[i][j] == word.charAt(0)) {
                    mark[i][j] = true;
                    result = search(board, i, j, word, 1, mark);
                    if (result)
                        return true;
                    mark[i][j] = false;
                }                
            } 
        return false;
    }
    
    private boolean search(char[][] board, int y, int x, String word, int index, boolean[][] mark) {
        if (index == word.length())
            return true;
    
        final int[][] steps = 
            new int[][] {
                { -1, 0 },
                {  1, 0 },
                { 0, -1 },
                { 0, 1  }
            };
    
        boolean result = false;        
        for (int i = 0; i < 4; i ++) {
            int ny = y + steps[i][0];
            int nx = x + steps[i][1];
            if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length || mark[ny][nx])
                continue;
            
            if (board[ny][nx] != word.charAt(index))
                continue;
            
            mark[ny][nx] = true;
            result = search(board, ny, nx, word, index + 1, mark);
            mark[ny][nx] = false;
            
            if (result)
                break;
        }
        return result;
    }
}