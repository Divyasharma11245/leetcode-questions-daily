class Solution {
    public int maxProfit(int[] prices) {
        int minimum = prices[0];
        int maxProfit = 0;
        for(int i = 0; i<prices.length; i++){
            int cost = prices[i]-minimum;
            maxProfit = Math.max(cost, maxProfit);
            minimum = Math.min(minimum, prices[i]);
        }
        return maxProfit;
    }
}