class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
       int ans[] = new int[n];
       Arrays.fill(ans, -1);
       for(int i = 0; i<n; i++){
        for(int j = i+1; j<=i+n-1; j++){
            int idx= j%n;
            if(nums[idx]>nums[i]){
                ans[i] = nums[idx];
                break;
            }
        }
       }
       return ans;
    }
}