public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
            
        int min = prices[0];
        int cur = prices[0];
        int pre = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i ++) {
            if (prices[i] < pre && pre > min) {
                profit += pre - min;
                min = prices[i];
            } else if (prices[i] > pre && pre < min)
                min = pre;
            pre = prices[i];
        }
        
        if (pre > min)
            profit += pre - min;
        return profit;
    }
}