class Solution {
    private int profit(int idx, int buy, int prices[], int n, int count, int dp[][][]){
        if(count==0){
            return 0;
        }
        if(idx==n){
            return 0;
        }
        if(dp[idx][buy][count]!=-1){
            return dp[idx][buy][count];
        }
        int profit = 0;
        if(buy==1){
            profit = Math.max(-prices[idx]+profit(idx+1, 0, prices, n, count, dp),
            0+profit(idx+1, 1, prices, n, count, dp));
        }else{
            profit = Math.max(prices[idx]+profit(idx+1, 1, prices, n, count-1, dp),
            0+profit(idx+1, 0, prices, n, count, dp));
        }
        return dp[idx][buy][count] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][3];
        //cap=0
        for(int idx = 0; idx<dp.length; idx++){
            for(int buy = 0; buy<dp[0].length; buy++){
                dp[idx][buy][0] = 0;
            }
        }
        //idx=n
        for(int buy = 0; buy<dp[0].length; buy++){
            for(int cap =0; cap<3; cap++){
                dp[n][buy][cap] = 0;
            }
        }

        for(int i = n-1; i>=0; i--){
            for(int j = 0; j<2; j++){
                for(int cap = 1; cap<3; cap++){
                    int profit = 0;
                    if(j==1){
                        dp[i][j][cap] = Math.max(-prices[i]+dp[i+1][0][cap],
                        0+dp[i+1][1][cap]);
                    }else{
                        dp[i][j][cap]  = Math.max(prices[i]+dp[i+1][1][cap-1],
                        0+dp[i+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}