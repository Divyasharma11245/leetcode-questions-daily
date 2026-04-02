class Solution {
    int n;
    int m;
    int[][][] dp;
    private int solve(int[][] coins, int i, int j , int neu){
        if(i==m-1 &&j==n-1){
            if(coins[i][j]<=0&&neu>0){
                return 0;
            }
            return coins[i][j];        
        }

        if(i>=m||j>=n){
            return Integer.MIN_VALUE;
        }

        if(dp[i][j][neu]!=Integer.MIN_VALUE){
            return dp[i][j][neu];
        }

        int keep = coins[i][j]+Math.max(solve(coins, i, j+1, neu), solve(coins, i+1, j, neu));

        int skip = Integer.MIN_VALUE;
        if(coins[i][j]<=0&&neu>0){
            int skipDown = solve(coins, i+1, j, neu-1);
            int skipRight = solve(coins, i, j+1, neu-1);
            skip = Math.max(skipDown, skipRight);
        }

        return dp[i][j][neu] =  Math.max(skip, keep);
    }
    public int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;
        dp = new int[m][n][3];
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                for(int k =0; k<3; k++){
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        return solve(coins, 0, 0, 2);
    }
}