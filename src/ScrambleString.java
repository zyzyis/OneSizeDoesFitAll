public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int len = s1.length();
        boolean[][][] d = new boolean[len][len][len + 1];
        for (int i = 0; i < len; i ++) { // initialize the distance
            d[i] = new boolean[len][len];
            for (int j = 0; j < len; j ++) {
                d[i][j] = new boolean[len + 1];
                d[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
                
        for (int k = 2; k <= len; k ++)
            for (int i = 0; i + k <= len; i ++)
                for (int j = 0; j + k <= len; j ++) {
                    for (int z = 1; z < k; z ++) // check the scramble position
                        if ((d[i][j][z] && d[i + z][j + z][k - z]) ||
                            (d[i][j + k - z][z] && d[i + z][j][k - z])) {
                            d[i][j][k] = true;
                            break;
                        }
                }
        return d[0][0][len];
    }
}
