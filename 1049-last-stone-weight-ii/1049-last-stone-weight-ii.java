class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum =0;
        for(int i =0; i<n; i++) sum+=stones[i];
        int target = sum/2;
        int dp[][] = new int[n+1][target+1];
        // for(int i =stones[0]; i<=target; i++){
        //     dp[0][i] = stones[0];
        // }
        for(int i =1; i<=n; i++){
            for(int j =0; j<=target; j++){
                int pick =0;
                if(stones[i-1]<=j){
                    pick = stones[i-1]+dp[i-1][j-stones[i-1]];
                }
                int notPick = dp[i-1][j];
                dp[i][j] = Math.max(pick, notPick);
            }
        }
        return sum-2*dp[n][target];
    }
}