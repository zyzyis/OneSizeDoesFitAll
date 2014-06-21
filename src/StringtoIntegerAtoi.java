public class Solution {
    public int atoi(String str) {
        String target = str.trim();
        int base = 0;
        int sign = 1;
        boolean overflow = false;
        for (int i = 0; i < target.length(); i ++) {
            char c = target.charAt(i);
            if ((i == 0) && (c == '-' || c == '+')) {
                sign = (c == '-') ? -1 : 1;
                continue;
            }
                    
            if (c >= '0' && c <= '9') {
                if (base > 100000000) {
                    double tmp = base * 10.0 + (double)(c - '0');
                    if (tmp > Integer.MAX_VALUE) {
                        overflow = true;
                        break;
                    }
                }
                base = base * 10 + (int)(c - '0');
            } else {
                break;
            }        
        }
        
        if (overflow)
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        return base * sign;
    }
}