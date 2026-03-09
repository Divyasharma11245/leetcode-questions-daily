class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int buy = 1;
        int dp[][] = new int[n+1][2];
        int profit = 0;
        for(int idx = n-1; idx>=0; idx--){
            for(int j = 0; j<=1; j++){
                if(j==1){
                    dp[idx][j] = Math.max(-prices[idx]+dp[idx+1][0], 
                    0+dp[idx+1][1]);
                }else{
                    dp[idx][j] = Math.max(prices[idx]-fee+dp[idx+1][1],
                    0+dp[idx+1][0]);
                }
            }
        }
        return dp[0][1];
    }
}