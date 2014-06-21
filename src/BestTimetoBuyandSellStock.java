public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i ++) {
            if (prices[i] < min) {
                min = prices[i];
                max = Integer.MIN_VALUE;
            } else {
                max = Math.max(max, prices[i]);
                maxProfit = Math.max(maxProfit, max - min);
            }
        }
        return maxProfit;
    }
}