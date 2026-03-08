class Solution {
    public int maxProfit(int k, int[] prices) {
       int n = prices.length;
       int dp[][][] = new int [n+1][2][k+1];

       //cap=0
        for(int i = 0; i<n; i++){
            for(int buy = 0; buy<2; buy++){
                dp[n][buy][0] = 0;
            }
        }

        //indx=n
        for(int buy = 0; buy<2; buy++){
            for(int c = 0; c<k; c++){
                dp[n][buy][c] = 0;
            }
        }

        for(int i = n-1; i>=0; i--){
            for(int j = 0; j<2; j++){
                for(int cap = 1; cap<=k; cap++){
                    int profit = 0;
                    if(j==1){
                        dp[i][j][cap] = Math.max(-prices[i]+dp[i+1][0][cap],
                        0+dp[i+1][1][cap]);
                    }else{
                        dp[i][j][cap]  = Math.max(prices[i]+dp[i+1][1][cap-1],
                        0+dp[i+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}