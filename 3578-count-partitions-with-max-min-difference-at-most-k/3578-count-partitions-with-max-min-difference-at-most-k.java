class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long MOD = 1_000_000_007;

        long[] dp = new long[n + 1];  // dp[i] = ways to partition first i elements
        long[] prefix = new long[n + 1];  // prefix sum of dp
        dp[0] = 1;
        prefix[0] = 1;

        int left = 0;
        int max = nums[0];
        int min = nums[0];

        for (int right = 1; right <= n; right++) {

            // Extend window to include nums[right-1]
            if (right == 1) {
                max = min = nums[0];
            } else {
                max = Math.max(max, nums[right - 1]);
                min = Math.min(min, nums[right - 1]);
            }

            // Shrink window until max - min <= k
            while (max - min > k) {
                left++;
                // Recalculate max and min for the new window
                max = nums[left];
                min = nums[left];
                for (int j = left + 1; j < right; j++) {
                    max = Math.max(max, nums[j]);
                    min = Math.min(min, nums[j]);
                }
            }

            // dp[right] = sum of dp[left ... right-1]
            dp[right] = (prefix[right - 1] - (left == 0 ? 0 : prefix[left - 1]) + MOD) % MOD;
            prefix[right] = (prefix[right - 1] + dp[right]) % MOD;
        }

        return (int) dp[n];
    }
}
