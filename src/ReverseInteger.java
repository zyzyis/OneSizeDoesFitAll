public class Solution {
    public int reverse(int x) {
        String str = Integer.toString(x);
        StringBuffer buf = new StringBuffer();
        if (x < 0)
            buf.append('-');
        int p = str.length() - 1;
        boolean headingZero = true;
        int end = x < 0 ? 1 : 0;
        while (p >= end) {
            char c = str.charAt(p --);
            if (c == '0' && headingZero && p != -1)
                continue;
            headingZero = false;
            buf.append(c);
        }
        return Integer.parseInt(buf.toString());
    }
}