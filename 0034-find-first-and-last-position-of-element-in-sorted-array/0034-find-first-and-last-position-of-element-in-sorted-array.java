class Solution {
     int lowerBound(int[] arr, int target) {
        int n = arr.length;
        int st = 0;
        int end = n-1;
        int ans = n;
        while(st<=end){
            int mid = st+(end-st)/2;
            if(arr[mid]>=target){
                ans = mid;
                end = mid-1;
            }else{
                st = mid+1;
            }
        }
        return ans;
    }

    int upperBound(int[] arr, int target) {
        int n = arr.length;
        int st = 0;
        int end = n-1;
        int ans = n;
        while(st<=end){
            int mid = st+(end-st)/2;
            if(arr[mid]>target){
                ans = mid;
                end = mid-1;
            }else{
                st = mid+1;
            }
        }
        return ans;  
    }
    public int[] searchRange(int[] nums, int target) {
        int lb = lowerBound(nums, target);
        if(lb==nums.length||nums[lb]!=target) return new int[]{-1, -1};
        int ub = upperBound(nums, target);
        return new int[] {lb, ub-1};
    }
}