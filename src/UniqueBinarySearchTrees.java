public class Solution {
    public int numTrees(int n) {
        int[] m = new int[n + 1];
        m[0] = 1;
        for (int k = 1; k <= n; k ++) {
            int remain = k - 1;
            int tmp = remain / 2 + remain % 2;
            for (int i = 0; i < tmp; i ++)
                m[k] += (m[i] * m[remain - i]) * 2;
            if (remain % 2 == 0)
                m[k] += m[remain / 2] * m[remain / 2];
        }
        return m[n];
    }
}