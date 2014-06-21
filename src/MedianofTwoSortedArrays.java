public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        double result = 0;
        int total = A.length + B.length;
        result = findK(A, B, 0, 0, (total + 1) / 2);
        if (total % 2 == 0)
            result = (findK(A, B, 0, 0, (total + 1) / 2 + 1) + result) * 0.5;
        return result;
    }
    // k means the Kth number in the merged two array, K is always bigger than 0.
    private int findK(int[] A, int[] B, int pa, int pb, int k) {
        int lenA = A.length - pa, lenB = B.length - pb;
        // we assume array A is always shorter than B, so that line 23 mb won't have overflow.
        if (lenA > lenB)
            return findK(B, A, pb, pa, k);
        if (lenA == 0)
            return B[k - 1];
        if (k == 1)
            return Math.min(A[pa], B[pb]);

        int result;
        // calculate the possible length for array A 
        int len = Math.min(lenA, k / 2);
        int ma = pa + len - 1, mb = pb + k - len - 1;
        if (A[ma] > B[mb]) {
            // move array B k - len forward
            result = findK(A, B, pa, pb + k - len, len);
        } else if (A[ma] < B[mb]) {
            // move array A len forward
            result = findK(A, B, pa + len, pb, k - len);
        } else
            result = A[ma];
        return result;
    }
}