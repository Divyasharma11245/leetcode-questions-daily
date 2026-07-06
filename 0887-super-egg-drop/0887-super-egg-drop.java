class Solution {
    public int superEggDrop(int k, int n) {
       int dp[][] = new int[k+1][n+1];

       for(int i = 1; i<=k; i++){
        for(int j = 1; j<=n; j++){
            if(i==1) dp[i][j] = j;
            else if(j==1) dp[i][j] = 1;
            else{
                int low = 1;
                int high = j;
                int ans = Integer.MAX_VALUE;

                while(low <= high){

                    int mid = low + (high-low)/2;

                    int broken = dp[i-1][mid-1];
                    int notBroken = dp[i][j-mid];

                    int temp = 1 + Math.max(broken, notBroken);

                    ans = Math.min(ans, temp);

                    if(broken > notBroken){
                        high = mid-1;
                    }else{
                        low = mid+1;
                    }
                }

            dp[i][j] = ans;
            }
        }
       } 
       return dp[k][n];
    }
}