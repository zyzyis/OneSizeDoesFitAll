public class Solution {
    private int result;
    private int getValue(String s, int p) {
        char c = s.charAt(p);
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -10000;
        }
    }
    
    private int getV(String s, int c, int m, int u, int cur) {
        int v = getValue(s, cur --);
        if (v == c) {
            result += v;
            while (cur >= 0) {
                v = getValue(s, cur);
                if (v == c) {
                    result += v;
                    cur --;
                } else if (v == m) {
                    result += v;
                    cur --;
                    break;
                } else
                    break;
            }
        } else if (v == m) {
            result += v;
            if (cur >= 0) {
                v = getValue(s, cur);
                if (v == c) {
                    result -= v;
                    cur --;
                }
            }
        } else if (v == u) {
            result += v;
            if (cur >= 0) {
                v = getValue(s, cur);
                if (v == c) {
                    result -= v;
                    cur --;
                }
            }
        } else {
            cur ++;
        }
        return cur;
    }
    
    public int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return 0;
            
        int cur = s.length() - 1;
        cur = getV(s, 1, 5, 10, cur);
        if (cur >= 0)
            cur = getV(s, 10, 50, 100, cur);
        if (cur >= 0)
            cur = getV(s, 100, 500, 1000, cur);
        if (cur >= 0)
            cur = getV(s, 1000, 5000, 10000, cur);
        return result;
    }
}