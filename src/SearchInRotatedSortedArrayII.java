public class Solution {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0)
            return false;
        int left = 0, right = A.length - 1, result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target) {
                result = mid;
                break;
            }
            
            if (A[mid] > A[left]) {
                if (target < A[mid] && target >= A[left])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if (A[mid] < A[left]) {
                if (target > A[mid] && target <= A[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else
                left ++;
        }
        return result != -1;
    }
}