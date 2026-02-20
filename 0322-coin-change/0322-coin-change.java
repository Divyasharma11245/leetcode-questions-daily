class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];

        for(int i = 0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j = 1; j<dp[0].length; j++){
            dp[0][j] = Integer.MAX_VALUE-1;
        }

        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[0].length; j++){
                if(coins[i-1]<=j){
                    dp[i][j] = Math.min(1+dp[i][j-coins[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if(dp[n][amount] ==  Integer.MAX_VALUE-1)
            return -1;

        return dp[n][amount];
    }
}