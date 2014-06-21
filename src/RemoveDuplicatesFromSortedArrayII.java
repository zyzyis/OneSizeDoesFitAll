public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length < 3)
            return A == null ? 0 : A.length;
        int p0 = 2;
        int p1 = 2;
        int count = 0;
        while (p1 < A.length) {
            A[p0] = A[p1];
            if (A[p0] == A[p0 - 1] && A[p0] == A[p0 - 2]) {
                while (p1 < A.length && A[p1] == A[p0])
                    p1 ++;
                if (p1 >= A.length)
                    break;
            } else {
                p0 ++;
                p1 ++;
            }
        }
        return p0;
    }
}