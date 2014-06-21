public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix != null && matrix.length != 0) {
            int[][] steps = new int[][] {{0,1}, {1,0}, {0,-1},{-1,0}};
            boolean[][] mask = new boolean[matrix.length][];
            for (int i = 0; i < matrix.length; i ++)
                mask[i] = new boolean[matrix[0].length];
                
            int cur = 0;
            int x = 0;
            int y = 0;
            while (true) {
                result.add(matrix[x][y]);
                mask[x][y] = true;
                boolean changed = false;
                // start to walk in clockwise order until no where to go
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
        return result;
    }
}