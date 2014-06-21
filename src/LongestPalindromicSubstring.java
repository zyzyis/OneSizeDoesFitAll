public class Solution {
    private int maxLen = 0;
    private int maxStart = 0;
    private int maxEnd = 0;
    private void expand(String s, int head, int tail) {
        while (head >= 0 && tail < s.length()) {
            char hc = s.charAt(head);
            char tc = s.charAt(tail);
            if (hc != tc)
                break;
            head --;
            tail ++;
        }

        head ++;
        tail --;

        if (tail - head + 1 > maxLen) {
            maxLen = tail - head + 1;
            maxStart = head;
            maxEnd = tail;
        }
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len; i ++) {
            if (maxLen > (len - i) * 2)
                break;
            expand(s, i, i);
            if (i < len - 1 && s.charAt(i) == s.charAt(i + 1))
                expand(s, i, i + 1);
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}