class Solution {
    public int singleNumber(int[] nums) {
        int prev = nums[0];
        int ans = 0;
        for(int i = 1; i<nums.length; i++){
            prev = prev^nums[i];
        }
        return prev;
    }
}