public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int p0 = m - 1, p1 = B.length - 1, p = A.length - 1;
        int tmp;
        while (p0 != -1 || p1 != -1) {
            if (p0 >= 0 && p1 == -1)
                tmp = A[p0 --];
            else if (p1 >= 0 && p0 == -1)
                tmp = B[p1 --];
            else if (A[p0] > B[p1])
                tmp = A[p0 --];
            else
                tmp = B[p1 --];
            A[p --] = tmp;
        }
    }
}