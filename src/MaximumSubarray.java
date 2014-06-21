public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int maxSum = A[0];
        int curSum = A[0];
        for (int i = 1; i < A.length; i ++) {
            curSum = Math.max(A[i], curSum + A[i]);
            maxSum = Math.max(curSum, maxSum);             
        }
        
        return maxSum;
    }
}