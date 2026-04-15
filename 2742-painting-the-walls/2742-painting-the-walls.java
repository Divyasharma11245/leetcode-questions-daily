class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int dp[][] = new int[n+1][n+1];
        for(int i =0; i<n+1; i++){
            dp[i][0] = 0;
        }
        for(int i=1; i<n+1; i++){
            dp[n][i] = (int)1e9;
        }

        for(int idx=n-1; idx>=0; idx--){
            for(int rem=1; rem<=n; rem++){
                int nextRemaining = Math.max(0, rem-1-time[idx]);
                int paint = cost[idx]+dp[idx+1][nextRemaining];
                int notPaint = dp[idx+1][rem];
                dp[idx][rem] = Math.min(paint, notPaint);
            }
        }
        return dp[0][n];
    }
}