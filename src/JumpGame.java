public class Solution {
    public boolean canJump(int[] A) {
        if (A == null || A.length < 2)
            return true;
            
        int end = A[0];
        int cur = 1;
        while (cur <= end) {
            end = Math.max(A[cur] + cur, end);
            if (end >= A.length - 1)
                return true;
            cur ++;
        }
        return false;
    }
}