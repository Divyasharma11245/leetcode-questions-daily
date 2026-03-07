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
        int buy = 1;
        int count = 2;
        int idx = 0;
        int dp[][][] = new int[n][2][3];
        for(int i = 0; i<dp.length; i++){
            for(int j = 0; j<dp[0].length; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return profit(idx, buy, prices, n, count, dp);
    }
}