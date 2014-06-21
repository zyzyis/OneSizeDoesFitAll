public class Solution {
    public int sqrt(int x) {
        if (x <= 1)
            return x;
        return sqrt(0, x, x);
    }
    
    private int sqrt(int start, int end, double target) {
        if (start >= end - 1)
            return start;
        int mid = (end - start) / 2 + start;
        double pow2 = (double)mid * (double)mid;
        if (pow2 > target)
            return sqrt(start, mid, target);
        else if (pow2 == target)
            return mid;
        else
            return sqrt(mid, end, target);
    }