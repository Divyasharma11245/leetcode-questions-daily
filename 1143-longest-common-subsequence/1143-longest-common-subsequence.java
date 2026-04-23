class Solution {
    private int solve(String str1, String str2, int n, int m, int lcs, int dp[][]){
        if(n==0||m==0) return 0;
        if(str1==""||str2=="") return lcs;
        if(dp[n-1][m-1]!=-1){
            return dp[n-1][m-1];
        }
        if(str1.charAt(n-1)==str2.charAt(m-1)) return dp[n-1][m-1] = 1+solve(str1, str2, n-1, m-1, lcs, dp);
        else{
            int ans1 = solve(str1, str2, n-1, m, lcs, dp);
            int ans2 = solve(str1, str2, n, m-1, lcs, dp);
            return dp[n-1][m-1] = Math.max(ans1, ans2);
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n][m];
        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(text1, text2, n, m, 0, dp);
    }
}