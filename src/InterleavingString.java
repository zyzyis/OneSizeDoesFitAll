public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s2.length() + s1.length()) // quick test
            return false;
        boolean[][] d = new boolean[s3.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s3.length(); i ++)
            d[i] = new boolean[s2.length() + 1];
            
        d[0][0] = true; // initialize the values
        for (int i = 1; i <= s3.length() && i <= s1.length(); i ++)
            d[i][0] = s3.charAt(i - 1) == s1.charAt(i - 1) && d[i - 1][0];
        
        for (int i = 1; i <= s3.length(); i ++)
            for (int j = 1; j <= i && j <= s2.length(); j ++) {
                int k = i - j - 1;
                if (i - j - 1 >= 0 && k < s1.length())
                    d[i][j] = s3.charAt(i - 1) == s1.charAt(k) && d[i - 1][j];
                d[i][j] |= s3.charAt(i - 1) == s2.charAt(j - 1) && d[i - 1][j - 1];
            }
        return d[s3.length()][s2.length()];
    }
}