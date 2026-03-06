class Solution {
    public int buyOrSell(int idx, int buy, int prices[], int n, int dp[][]){
        if(idx==n) return 0;
        int profit = 0;
        if(dp[idx][buy] != -1){
            return dp[idx][buy];
        }
        if(buy==1){
            profit = Math.max(-prices[idx]+buyOrSell(idx+1, 0, prices, n, dp), 
            0+buyOrSell(idx+1, 1, prices, n, dp));
        }else{
            profit = Math.max(prices[idx]+buyOrSell(idx+1, 1, prices, n, dp),
            0+buyOrSell(idx+1, 0, prices, n, dp));
        }
        return dp[idx][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int idx=0;
        int buy = 1;
        int dp[][] = new int[n][2];
        for(int i = 0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return buyOrSell(idx, buy, prices, n, dp);
    }
}