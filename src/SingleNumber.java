public class Solution {
    public int singleNumber(int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i ++)
            xor = A[i] ^ xor;
        return xor;
    }
}