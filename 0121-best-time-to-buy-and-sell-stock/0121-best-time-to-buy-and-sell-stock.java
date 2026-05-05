class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minLeft[] = new int[n];
        int maxRight[] = new int[n];
        minLeft[0] = prices[0];
        for(int i =1; i<n; i++){
            minLeft[i] = Math.min(minLeft[i-1], prices[i]);
        }

        maxRight[n-1] = prices[n-1];
        for(int i = n-2; i>=0; i--){
            maxRight[i] = Math.max(maxRight[i+1], prices[i]);
        }

        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            maxProfit = Math.max(maxProfit, maxRight[i]-minLeft[i]);
        }
        return maxProfit;
    }
}