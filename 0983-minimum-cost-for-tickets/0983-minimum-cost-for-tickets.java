class Solution {
    private int solve(int[] days, int[] costs, int n, int i, int dp[]){
        if(i>=days.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int cost1 = costs[0]+solve(days, costs, n, i+1, dp);
        
        int j = i;
        int maxDays7 = days[i]+7;
        while(j<n&&days[j]<maxDays7){
            j++;
        }
        int cost2 = costs[1]+solve(days, costs, n, j, dp);

        int k = i;
        int maxDays30 = days[i]+30;
        while(k<n&&days[k]<maxDays30){
            k++;
        }
        int cost3 = costs[2]+solve(days, costs, n, k, dp);

        return dp[i] = Math.min(cost1, Math.min(cost2, cost3));
    }
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int dp[] = new int[366];
        Arrays.fill(dp, -1);
        return solve(days, costs, n, 0, dp);
    }
}