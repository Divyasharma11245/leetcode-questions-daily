class Solution {
    private int func(int i, int j, int[] cut, int dp[][]){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int idx = i; idx<=j; idx++){
            int cost = cut[j+1]-cut[i-1]+func(i, idx-1, cut, dp)+func(idx+1, j, cut, dp);
            ans = Math.min(ans, cost);
        }
        return dp[i][j] = ans;
    }
    public int minCost(int n, int[] cuts) {
        int cut[] = new int[cuts.length+2];
        cut[0] = 0;
        cut[cut.length-1] = n;
        for(int i =1; i<cut.length-1; i++){
            cut[i] = cuts[i-1];
        }
        Arrays.sort(cut);
        int dp[][] = new int[cuts.length+1][cuts.length+1];
        for(int i =0; i<=cuts.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return func(1, cut.length-2, cut, dp);
    }
}