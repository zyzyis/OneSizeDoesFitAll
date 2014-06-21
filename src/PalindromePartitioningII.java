public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0)
            return 0;
        
        boolean[][] cache = new boolean[s.length()][];
        for (int i = 0; i < s.length(); i ++) {
            cache[i] = new boolean[s.length()];
            cache[i][i] = true;
        }
        
        for (int k = 1; k < s.length(); k ++) {
            for (int i = 0; i + k < s.length(); i ++) {
                int j = i + k;
                if (s.charAt(i) != s.charAt(j))
                    continue;
                if (i + 1 < j && !cache[i + 1][j - 1])
                    continue;
                cache[i][j] = true;
            }
        }

        int[] min = new int[s.length()];
        for (int i = 1; i < min.length; i ++) {
            if (cache[0][i])
                continue;
            int tmp = Integer.MAX_VALUE;
            for (int j = 0; j < i; j ++) {
                if (cache[j + 1][i] && tmp > min[j] + 1) 
                    tmp = min[j] + 1;
            }
            min[i] = tmp;
        }
        return min[s.length() - 1];
    }
}