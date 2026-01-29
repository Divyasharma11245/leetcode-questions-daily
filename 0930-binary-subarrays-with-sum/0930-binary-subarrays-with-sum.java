class Solution {
     public int noSub(int nums[],int k){
        if(k<0){
            return 0;
        }
        int l=0;
        int ans=0;
        int temp=0;
        for(int r=0;r<nums.length;r++){
            temp+=nums[r];
            while(temp>k){
                temp-=nums[l];
                l++;
            }
            ans+=r-l+1;
        }
        return ans;

    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        int finalans=noSub(nums,goal)-noSub(nums,goal-1);
        return finalans;
    }
}