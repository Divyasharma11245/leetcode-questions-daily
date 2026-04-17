class Solution {
    private boolean solve(int sum, int i, int[] nums, Boolean dp[][]){
        if(sum==0){
            return true;
        }
        if(i>=nums.length||sum<0){
            return false;
        }
        if(dp[i][sum]!=null){
            return dp[i][sum];
        }
        boolean take = false;
        if(nums[i] <= sum){
            take = solve(sum - nums[i], i + 1, nums, dp);
        }

        boolean notTake = solve(sum, i + 1, nums, dp);


        return dp[i][sum] = take || notTake;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i =0; i<n; i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        Boolean dp[][] = new Boolean[n][(sum/2)+1];
        return solve(sum/2, 0, nums, dp);
    }
}