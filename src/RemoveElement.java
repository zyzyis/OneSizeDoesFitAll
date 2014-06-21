public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0)
            return 0;
            
        int len = A.length;
        int cur = 0;
        while (cur < len) {
            if (A[cur] == elem) {
                while (A[len - 1] == elem && len - 1 > cur)
                    len --;
                if (len - 1 == cur) {
                    len = cur;
                    break;
                }
                A[cur] = A[len - 1];
                len --;
            } else {
                cur ++;
            }
        }
        return len;
    }
}