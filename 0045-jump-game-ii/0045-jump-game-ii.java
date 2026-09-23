class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int l = 0;
        int r = 0 ;
        while(r<n-1){
            int farthest = 0;
            for(int idx = l; idx<=r; idx++){
                farthest = Math.max(farthest, idx+nums[idx]);
            }
            l = r+1;
            r = farthest;
            jumps++;
        }
        return jumps;
    }
}