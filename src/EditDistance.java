public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null)
            return 0;
        if (word1 == null || word1.length() == 0)
            return word2.length();
        if (word2 == null || word2.length() == 0)
            return word1.length();
            
        int[][] d = new int[word1.length() + 1][];
        for (int i = 0; i <= word1.length(); i ++) {
            d[i] = new int[word2.length() + 1];
            d[i][0] = i;
            for (int j = 0; j <= word2.length(); j ++)
                d[0][j] = j;
         }            
                
        for (int i = 1; i <= word1.length(); i ++) {
            for (int j = 1; j <= word2.length(); j ++) {
                int count = Integer.MAX_VALUE;
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    count = d[i - 1][j - 1];
                else
                    count = d[i - 1][j - 1] + 1;
                
                d[i][j] = 
                    Math.min(Math.min(d[i - 1][j] + 1, d[i][j - 1] + 1), count);                
            }               
        }
        return d[word1.length()][word2.length()];
    }   
}