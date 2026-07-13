class Solution {
    long[] prefix;
    private int binSearch(int target_idx, int k, int[] nums){
        int l = 0;
        int r = target_idx;
        int res=0;
        while(l<=r){
            int mid = l+(r-l)/2;
            int count = target_idx-mid+1;
            long targetSum = 1L * count * nums[target_idx];
            long orgSum;
            if (mid == 0)
                orgSum = prefix[target_idx];
            else
                orgSum = prefix[target_idx] - prefix[mid - 1];
            long operations = targetSum - orgSum;
            if(operations>k){
                l = mid+1;
            }else{
                res = mid;
                r = mid-1;
            }
        }
        return target_idx-res+1;
    }
    public int maxFrequency(int[] nums, int k) {
         int n = nums.length;
        int res = Integer.MIN_VALUE;
        Arrays.sort(nums);
        prefix = new long[n];
        prefix[0] = nums[0];
        for(int i = 1; i<n; i++){
            prefix[i] = nums[i]+prefix[i-1];
        }
        for(int i = 0; i<n; i++){
            int freq = binSearch(i, k, nums);
            res = Math.max(res, freq);
        }
        return res;
    }
}