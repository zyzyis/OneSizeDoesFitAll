public class Solution {
    public int[] searchRange(int[] A, int target) {
        int p = binarySearch(A, target, 0, A.length);
        if (p == A.length || A[p] != target)
            return new int[] { -1, -1 };
         
        int p0 = binarySearch(A, target - 0.9, 0, p);
        int p1 = binarySearch(A, target + 0.9, p + 1, A.length);
        return new int[] { p0, p1 - 1 };
    }
 
    private int binarySearch(int[] A, double target, int start, int end) {
        int result = start;
        if (start != end) {
            int mid = (end - start) / 2 + start;
            if (A[mid] == target)
                result = mid;
            else if (A[mid] > target)
                result = binarySearch(A, target, start, mid);
            else
                result = binarySearch(A, target, mid + 1, end);
        }
        return result;
    }
}