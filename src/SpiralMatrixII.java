public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] steps = new int[][] {{0,1}, {1,0}, {0,-1},{-1,0}};
        boolean[][] mask = new boolean[n][];
        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i ++) {
            mask[i] = new boolean[n];
            matrix[i] = new int[n];
        }
        
        if (n > 0) {
            int cur = 0;
            int index = 1;
            int x = 0, y = 0;
            while (true) {
                matrix[x][y] = index ++;
                mask[x][y] = true;
                boolean changed = false;
                for (int i = 0; i < 4; i ++, cur = (cur + 1) % 4) {
                    int nx = x + steps[cur][0];
                    int ny = y + steps[cur][1];
                    if (nx >= 0 && nx < matrix.length && 
                        ny >= 0 && ny < matrix[0].length && 
                        !mask[nx][ny]) {
                        x = nx;
                        y = ny;
                        changed = true;
                        break;
                    }
                }
                if (!changed)
                    break;
            }
        }
        return matrix;
    }
}