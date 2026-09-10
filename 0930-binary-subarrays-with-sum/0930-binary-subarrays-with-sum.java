class Solution {
    private int atmostGoal(int[] nums, int goal){
        if(goal<0) return 0;
        int n = nums.length;
        int i = 0 ;
        int j = 0;
        int sum = 0;
        int count = 0;
        while(j<n){
            sum+=nums[j];
            while(sum>goal){
                sum-=nums[i];
                i++;
            }
            count+=(j-i+1);
            j++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmostGoal(nums, goal)-atmostGoal(nums, goal-1);
    }
}