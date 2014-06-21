public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String head = strs[0];
        for (int i = 0; i < head.length(); i ++) {
            for (int j = 1; j < strs.length; j ++) {
                if (strs[j].length() > i && head.charAt(i) == strs[j].charAt(i))
                    continue;
                return head.substring(0, i);
            }
        }
        return head;
    }
}