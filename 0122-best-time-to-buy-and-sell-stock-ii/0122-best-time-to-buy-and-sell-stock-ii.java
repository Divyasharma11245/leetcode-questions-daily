class Solution {
    // public int buyOrSell(int idx, int buy, int prices[], int n, int dp[][]){
    //     if(idx==n) return 0;
    //     int profit = 0;
    //     if(dp[idx][buy] != -1){
    //         return dp[idx][buy];
    //     }
    //     if(buy==1){
    //         profit = Math.max(-prices[idx]+buyOrSell(idx+1, 0, prices, n, dp), 
    //         0+buyOrSell(idx+1, 1, prices, n, dp));
    //     }else{
    //         profit = Math.max(prices[idx]+buyOrSell(idx+1, 1, prices, n, dp),
    //         0+buyOrSell(idx+1, 0, prices, n, dp));
    //     }
    //     return dp[idx][buy] = profit;
    // }
    public int maxProfit(int[] prices) {
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
                    dp[idx][j] = Math.max(prices[idx]+dp[idx+1][1],
                    0+dp[idx+1][0]);
                }
            }
        }
        return dp[0][1];
    }
}