class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int factors[] = new int[n];
        int price[] = new int  [n];
        int gain[] = new int[n];
        for(int i = 0; i<n; i++){
            factors[i] = items[i][0];
            price[i] = items[i][1];
        } 
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i!=j&&factors[j]%factors[i]==0){
                    gain[i]++;
                }
            }
        }
        int dp[][] = new int[n+1][budget+1];
        for(int i = 1; i<=n; i++){
            int cost = price[i-1];
            int value = gain[i-1]+1;
            for(int j = 0; j<=budget; j++){
                int not_take = dp[i-1][j];
                int take = 0;
                if(j>=cost){
                    take = dp[i-1][j-cost]+value;
                }
                dp[i][j] = Math.max(take, not_take);
            }
        }
        int cheapest = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i<n; i++){
            if(price[i]<cheapest){
                cheapest = price[i];
            }
        }
        for(int i = 0; i<=budget; i++){
            if(dp[n][i]==0){
                continue;
            }
            int remaining = budget-i;
            int total = dp[n][i]+remaining/cheapest;
            ans = Math.max(ans, total);

        }
        return ans;
    }
}