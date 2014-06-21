public class Solution {
    public String getPermutation(int n, int k) {
        int[] facto = new int[10];
        facto[0] = 1;
        for (int i = 1; i < 10; i ++)
            facto[i] = i * facto[i - 1];
            
        boolean[] mark = new boolean[n];
        StringBuffer buf = new StringBuffer();
        for (int i = 1; i <= n; i ++) {
            int tmp = (k - 1) / facto[n - i] + 1;
            for (int j = 0, count = 0; j < n; j ++)
                if (!mark[j]) {
                    count ++;
                    if (count == tmp) {
                        buf.append(j + 1);
                        mark[j] = true;
                        break;
                    }
                }
            k = k % facto[n - i] == 0 ? facto[n - i] : k % facto[n - i];
        }
        return buf.toString();
    }
}