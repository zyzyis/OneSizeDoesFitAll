public class Solution {
    public int singleNumber(int[] A) {
        int r1 = 0;     // r1 is for bit with count K % 3 = 1
        int r2 = 0;     // r2 is for bit with count K % 3 = 2
        for (int i = 0; i < A.length; i ++) {
            // r0 is for bit with count K % 3 = 0
            // r0 equals when the bit is not either in r1 and r2.
            int r0 = ~(r1 | r2);
            // r2 equals when the current bit is 0 and bit is in r2
            // or the current bit is 1 and bit is also in r1.
            r2 = (r2 & ~A[i]) | (r1 & A[i]);
            // r1 equals when the current bit is 0 and bit is in r1
            // or the curernt bit is 1 and bit is in r0.
            r1 = (r1 & ~A[i]) | (r0 & A[i]);
        }
        
        // return when either r1 or r2 is non-zero.
        return r1 == 0 ? r2 : r1;
    }
}