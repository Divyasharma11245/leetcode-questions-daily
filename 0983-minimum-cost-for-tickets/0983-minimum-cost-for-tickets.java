class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = days[days.length-1];
        int dp[] = new int[maxDay+1];

        dp[0] = 0;
        HashSet<Integer> st = new HashSet<>();
        for(int i =0; i<days.length; i++){
            st.add(days[i]);
        }

        for(int i =1; i<=maxDay; i++){
            if(!st.contains(i)){
                dp[i] = dp[i-1];
                continue;
            }
            int cost1 = costs[0]+dp[Math.max(i-1, 0)];
            int cost2 = costs[1]+dp[Math.max(i-7, 0)];
            int cost3 = costs[2]+dp[Math.max(i-30, 0)];
            dp[i] = Math.min(cost1, Math.min(cost2, cost3));
        }

        return dp[maxDay];
    }
}