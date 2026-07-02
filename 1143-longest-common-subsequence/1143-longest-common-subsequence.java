class Solution {
    private int lcs(String str1, String str2, int m, int n, int dp[][]){
        if(m<0||n<0) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        if(str1.charAt(m)==str2.charAt(n)) return dp[m][n] = lcs(str1, str2, m-1, n-1, dp)+1;
        else{
            int ans1 = lcs(str1, str2, m-1, n, dp);
            int ans2 = lcs(str1, str2, m, n-1, dp);
            return dp[m][n] = Math.max(ans1, ans2);
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        return lcs(text1, text2, m-1, n-1, dp);
    }
}