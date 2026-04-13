class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int st = 0;
        int en = n-1;
        if(n==1){
            return nums[n-1];
        }
        while(st<=en){
            int mid = st+(en-st)/2;
            if(mid==0&&nums[0]!=nums[1]) return nums[0];
            if(mid==n-1&&nums[n-1]!=nums[n-2]) return nums[n-1];
            if(nums[mid]!=nums[mid-1]&&nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            if(mid%2==0){
                if(nums[mid]==nums[mid-1]) en = mid-1;
                else st = mid+1;
            }else{
                if(nums[mid]==nums[mid-1]) st = mid+1;
                else en = mid-1;
            }
        }
        return -1;
    }
}