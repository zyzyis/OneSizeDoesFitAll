public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 1)
            return dividend;
            
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int result = 0;
        while (a >= b) {
            long tmp = b;
            for (int i = 0; a >= tmp; tmp <<= 1, i ++) {
                a -= tmp;
                result += 1 << i;
            }
        }
        
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            result = -result;
        return result;
    }
}