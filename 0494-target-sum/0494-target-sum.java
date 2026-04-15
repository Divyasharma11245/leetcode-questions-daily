class Solution {
    private int solve(int[] nums, int i, int currSum, int target){
        if(i==nums.length) return currSum == target ? 1 : 0;

        int add = solve(nums, i+1, currSum+nums[i], target);
        int sub = solve(nums, i+1, currSum-nums[i], target);

        return add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0, 0, target);
    }
}