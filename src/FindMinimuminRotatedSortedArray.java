public class Solution {
    public int findMin(int[] num) {
        return findMin(num, 0, num.length);
    }
    
    private int findMin(int[] num, int start, int end) {
        if (end - start <= 2)
            return Math.min(num[start], num[end - 1]);
        int medium = (start + end) / 2;
        if (num[medium] > num[end - 1])
            return findMin(num, medium, end);
        return findMin(num, 0, medium + 1);
    }
}
