public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null || dict.size() == 0)
            return false;
        boolean[] d = new boolean[s.length() + 1];
        d[0] = true;
        for (int i = 1; i <= s.length(); i ++) 
            for (int j = 0; j < i; j ++) {
                String token = s.substring(j, i);
                if (dict.contains(token) && d[j]) {
                    d[i] = true;
                    break;
                }
            }
        return d[s.length()];
    }
}