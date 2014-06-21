public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
        int start = 0;
        HashMap<Character, Integer> index = new HashMap<>();
        int maxLen = 0;
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (index.containsKey(c)) {
                maxLen = Math.max(maxLen, i - start);
                int tmp = index.get(c);
                for (int j = start; j <= tmp; j ++)
                    index.remove(s.charAt(j));
                start = tmp + 1;
            }
            index.put(c, i);
        }
        maxLen = Math.max(maxLen, s.length() - start);
        return maxLen;
    }
}