class Solution {

    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length+1][2];
        
        dp[0][0] = 0;
        dp[0][1] = 0;

        for(int idx=prices.length-1; idx>=0; idx--){
            for(int buy = 0; buy<=1; buy++){
                int profit = 0;
                if(buy==1){
                    dp[idx][buy] = Math.max(-prices[idx]+dp[idx+1][0], dp[idx+1][1]);
                }else{
                    dp[idx][buy] = Math.max(prices[idx]+dp[idx+1][1], dp[idx+1][0]);
                }
            }
        }
        return dp[0][1];
    }
}