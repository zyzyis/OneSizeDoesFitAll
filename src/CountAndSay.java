public class Solution {
    public String countAndSay(int n) {
        StringBuffer buf = new StringBuffer("1");
        for (int i = 1; i < n; i ++) {
            StringBuffer tmp = new StringBuffer();
            int p = 0;
            while (p < buf.length()) {
                char c = buf.charAt(p);
                int count, k;
                for (k = p, count = 0; k < buf.length() && buf.charAt(k) == c; k ++)
                    count ++;
                tmp.append(count).append(c);
                p = k;
            }
            buf = tmp;
        }
        return buf.toString();
    }
}