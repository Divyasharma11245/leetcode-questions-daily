class Solution {
    private int solve(int[] nums, int target, int idx, int dp[][]){
        if(target==0){
            return 1;
        }
        if(idx>=nums.length){
            return 0;
        }
        if(dp[idx][target]!=-1){
            return dp[idx][target];
        }
        int ways = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= target){
                ways += solve(nums, target - nums[i], 0, dp);
            }
        }

        return dp[idx][target] = ways;
    }
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int dp[][] = new int[n][target+1];
        for(int i =0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(nums, target, 0, dp);
    }
}