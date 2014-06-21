public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
            
        int m = board.length;
        int n = board[0].length;
        boolean[][] mark = new boolean[m][];
        for (int i = 0; i < m; i ++)
            mark[i] = new boolean[n];
            
        for (int i = 0; i < m; i ++) {
            if (!mark[i][0] && board[i][0] == 'O')
                fill(mark, board, i, 0);
            if (!mark[i][n - 1] && board[i][n - 1] == 'O')
                fill(mark, board, i, n - 1);
        }
        
        for (int i = 0; i < n; i ++) {
            if (!mark[0][i] && board[0][i] == 'O')
                fill(mark, board, 0, i);
            if (!mark[m - 1][i] && board[m - 1][i] == 'O')
                fill(mark, board, m - 1, i);
        }            
        
        for (int i = 0; i < m; i ++)
            for (int j = 0; j < n; j ++)
                if (!mark[i][j] && board[i][j] == 'O')
                    board[i][j] = 'X';
    }
    
    private void fill(boolean[][] mark, char[][] board, int y, int x) {
        final int[][] deltas =
            new int[][] {
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
            };
       
       Queue<Integer> queue = new LinkedList<Integer>();
       queue.add(y << 16 | x);
       mark[y][x] = true;
       while (!queue.isEmpty()) {
           int v = queue.poll();
           for (int i = 0; i < 4; i ++) {
               int ny = ((v >> 16) & 0xFFFF) + deltas[i][0];
               int nx = (v & 0xFFFF) + deltas[i][1];           
               if (ny < 0 || ny >= board.length || 
                   nx < 0 || nx >= board[0].length || 
                   mark[ny][nx] || board[ny][nx] != 'O'
               )
                   continue;
               queue.offer(ny << 16 | nx);
               mark[ny][nx] = true;
           }
       }
    }
}