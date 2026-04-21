class Solution {
    private int solve(int[] coins, int idx, int amount, int dp[][]){
        if(amount==0){
            return 0;
        }
        if(idx>=coins.length){
            return (int)1e9;
        }
        if(dp[idx][amount]!=-1){
            return dp[idx][amount];
        }
        int notTake = solve(coins, idx + 1, amount, dp);

        int take = (int)1e9;
        if(coins[idx] <= amount){
            int res = solve(coins, idx, amount - coins[idx], dp);
            if(res != (int)1e9){
                take = 1 + res;
            }
        }
        return dp[idx][amount] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1];
        for(int i =0; i<coins.length; i++){
            Arrays.fill(dp[i], -1);
        }
        int ans = solve(coins, 0, amount, dp);
        return ans >= (int)1e9 ? -1 : ans;
    }
}