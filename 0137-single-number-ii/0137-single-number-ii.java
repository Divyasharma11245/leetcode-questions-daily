class Solution {
    public int singleNumber(int[] nums) {
        //approach 3 - using simple maths
        Arrays.sort(nums);
       for(int i = 1; i<nums.length; i=i+3){
        if(nums[i]!=nums[i-1]){
            return nums[i-1];
        }
       }
       return nums[nums.length-1];
    }
}