public class Solution {
    public int climbStairs(int n) {
        if (n == 0)
            return 0;
        int[] d = new int[n + 1];
        d[0] = 1;
        for (int i = 0; i < n; i ++) {
            d[i + 1] += d[i];
            if (i + 2 <= n)
                d[i + 2] += d[i];
        }
        return d[n];
    }
}