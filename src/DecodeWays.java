public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        HashSet<String> idSet = new HashSet<String>();
        for (int i = 1; i <= 26; i ++)
            idSet.add(Integer.toString(i));
        
        int[] d = new int[s.length()];
        for (int i = s.length() - 1; i >= 0; i --) {
            if (i + 2 <= s.length()) {
                String twoDigits = s.substring(i, i + 2);
                if (idSet.contains(twoDigits)) {
                    if (i + 2 == s.length())
                        d[i] = 1;
                    else
                        d[i] = d[i + 2];
                }
            }
            
            String singleDigit = s.substring(i, i + 1);
            if (idSet.contains(singleDigit)) {
                if (i + 1 == s.length())
                    d[i] += 1;
                else
                    d[i] += d[i + 1];
            }
        }
        return d[0];
    }
}