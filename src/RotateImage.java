public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1)
            return;
        int len = matrix.length;
        int mid = len / 2 + (len % 2 == 1 ? 1 : 0);
        for (int i = 0; i < len / 2; i ++)
            for (int j = 0; j < mid; j ++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len - j - 1][i];
                matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
                matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
                matrix[j][len - i - 1] = tmp;
            }
    }
}