public class Solution {
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int high = A[0], low = A[0];
        int result = A[0];
        for (int i = 1; i < A.length; i ++) {
            int tmp = Math.max(A[i] * low, Math.max(A[i], A[i] * high));
            low = Math.min(A[i] * low, Math.min(A[i], A[i] * high));
            high = tmp;
            result = Math.max(high, result);
        }
        return result;
    }
}
