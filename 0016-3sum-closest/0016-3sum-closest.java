class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int result = 0;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int i = 0; i<n-2; i++){
            int left = i+1;
            int right = n-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];

                if(sum==target) return target;
                else if(sum>target) right--;
                else left++;

                int diff = Math.abs(sum-target);
                if(diff < minDiff){
                    minDiff = diff;
                    result = sum;
                }
            }
        }
        return result;
    }
}