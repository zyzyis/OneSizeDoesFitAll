public class Solution {
    public int findMin(int[] num) {
        return findMin(num, 0, num.length);    
    }
    
    private int findMin(int[] num, int start, int end) {
        int mid = (start + end) / 2;
        int result;
        if (end - start <= 2)
            result = Math.min(num[start], num[end - 1]);
        else if (num[mid] > num[start] && num[mid] < num[end - 1])
            result = num[start];
        else if (num[mid] > num[start])
            result = findMin(num, mid + 1, end);
        else
            result = findMin(num, start + 1, mid + 1);
        return result;
    }
}
