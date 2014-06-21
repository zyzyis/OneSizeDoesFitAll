public class Solution {
    public int jump(int[] A) {
        if (A == null || A.length < 2)
            return 0;        
        
        int curEnd = 0, nextEnd = 0;
        int cur = 0;
        int step = 0;
        while (cur <= nextEnd) {
            if (cur > curEnd) {
                curEnd = nextEnd;
                step ++;
            }
            
            nextEnd = Math.max(nextEnd, A[cur] + cur);
            if (nextEnd >= A.length - 1)
                break;
            cur ++;
        }
        return step + 1;
    }
}