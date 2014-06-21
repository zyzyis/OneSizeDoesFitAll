public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int[] p0 = new int[prices.length];
        int[] p1 = new int[prices.length];
        int min = prices[0];
        
        for (int i = 1; i < prices.length; i ++) {
            if (prices[i] <= min) {
                min = prices[i];
                p0[i] = p0[i - 1];
            } else 
                p0[i] = Math.max(p0[i - 1], prices[i] - min);
        }
        
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i --) {
            if (prices[i] >= max) {
                max = prices[i];
                p1[i] = p1[i + 1];
            } else 
                p1[i] = Math.max(p1[i + 1], max - prices[i]);
        }
        
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i ++)
            maxProfit = Math.max(p0[i] + p1[i], maxProfit);
        return maxProfit;
    }
}