public class Solution {
    public int firstMissingPositive(int[] A) {
        for (int i = 0; i < A.length; i ++) {
            int p = A[i];
            A[i] = -1;
            while (p <= A.length && p > 0 && A[p - 1] != p) {
                int tmp = A[p - 1];
                A[p - 1] = p;
                p = tmp;
            }
        }
        
        for (int i = 0; i < A.length; i ++)
            if (A[i] <= 0)
                return i + 1;
        return A.length + 1;
    }
}