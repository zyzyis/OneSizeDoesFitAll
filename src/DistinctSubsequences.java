public class Solution {
    public int numDistinct(String S, String T) {
        int[][] d = new int[T.length() + 1][S.length() + 1];
        for (int i = 1; i <= T.length(); i ++)
            for (int j = i; j <= S.length(); j ++)
                if (S.charAt(j - 1) == T.charAt(i - 1))
                    d[i][j] = i == 1 ? d[i][j - 1] + 1 : d[i - 1][j - 1] + d[i][j - 1];
                else
                    d[i][j] = d[i][j - 1];
        return d[T.length()][S.length()];
    }
}