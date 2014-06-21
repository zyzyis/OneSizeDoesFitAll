public class Solution {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0)
            return 0;
        return searchInsert(A, target, 0, A.length);    
    }
    
    private int searchInsert(int[] A, int target, int start, int end) {
        if (start == end - 1) {
            if (A[start] >= target)
                return start;
            return end;
        }
        
        int mid = (start + end) / 2;
        if (A[mid] == target)
            return mid;
        if (A[mid] > target)
            return searchInsert(A, target, start, mid);
        else
            return searchInsert(A, target, mid, end);
    }
}