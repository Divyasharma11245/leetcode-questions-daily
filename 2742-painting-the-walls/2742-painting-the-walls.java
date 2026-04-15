class Solution {
    private int solve(int idx, int remaining, int cost[], int time[], int dp[][]){
        int n = cost.length;
        if(remaining<=0){
            return 0;
        }
        if(idx>=n){
            return (int)1e9;
        }
        if(dp[idx][remaining]!=-1){
            return dp[idx][remaining];
        }
        int paint = cost[idx]+solve(idx+1, remaining-1-time[idx], cost, time, dp);
        int notPaint = solve(idx+1, remaining, cost, time, dp);

        return dp[idx][remaining] = Math.min(paint, notPaint);
    }
    public int paintWalls(int[] cost, int[] time) {
        int dp[][] = new int[cost.length][cost.length+1];
        
        for(int i =0; i<cost.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(0, cost.length, cost, time, dp);
    }
}