class Solution {
    private int findSum(int[] nums, int mid){
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum+=(nums[i]+mid-1)/mid;
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
             high = Math.max(high, nums[i]);
        }
        int ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            int sum = findSum(nums, mid);
            if(sum<=threshold){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}