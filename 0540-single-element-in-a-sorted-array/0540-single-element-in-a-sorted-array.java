class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int xor = nums[0];
        for(int i = 1; i<n; i++){
            xor = xor^nums[i];
        }
        return xor;
    }
}