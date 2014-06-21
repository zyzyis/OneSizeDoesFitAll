public class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || 
                (c >= 'A' && c <= 'Z') || 
                (c >= '0' && c <= '9')
            )
                buf.append(
                    (c >= 'A' && c <= 'Z') ? (char)(c - 'A' + 'a') : c);
        }
        
        int p0 = 0, p1 = buf.length() - 1;
        while (p0 < p1) {
            if (buf.charAt(p0 ++) != buf.charAt(p1 --))
                return false;
        }
        return true;
    }
}