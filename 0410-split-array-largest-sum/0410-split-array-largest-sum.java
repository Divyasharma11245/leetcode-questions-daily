class Solution {
    private boolean isValid(int[] arr, long mid, int k){
        long sum = 0;
        int stu = 1;
        for(int i = 0; i<arr.length; i++){
            sum+=arr[i];
            if(sum>mid){
                stu++;
                sum = arr[i];
            }
        }
        if(stu<=k) return true;
        return false;
    }
    public int splitArray(int[] nums, int k) {
    long low = Integer.MIN_VALUE;
        long high = 0;
        for(int i = 0; i<nums.length; i++){
            low = Math.max(low, nums[i]);
            high+=nums[i];
        }

        long ans = -1;
        if(nums.length<k) return -1;
        while(low<=high){
            long mid = low+(high-low)/2;
            if(isValid(nums, mid, k)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return (int)ans;
        
    }
}