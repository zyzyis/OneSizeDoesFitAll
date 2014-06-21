public class Solution {
    public String addBinary(String a, String b) {
        StringBuffer buf = new StringBuffer();
        int m = a.length();
        int n = b.length();
        int add = 0;
        for (int i = 0; i < Math.max(m, n); i ++) {
            int c0, c1;
            if (i >= m)
                c0 = 0;
            else
                c0 = (int)(a.charAt(m - i - 1) - '0');
            if (i >= n)
                c1 = 0;
            else
                c1 = (int)(b.charAt(n - i - 1) - '0');
            int v = c1 + c0 + add;
            add = v / 2;
            v = v % 2;
            buf.append(v);
        }
        if (add != 0)
            buf.append(add);
        return buf.reverse().toString();
    }
}