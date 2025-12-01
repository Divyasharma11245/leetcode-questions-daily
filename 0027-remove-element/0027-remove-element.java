class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        int j = 0;

        if(n==0){
            return 0;
        }

        

        while(j<n){
            if(nums[j]!=val){
                nums[i] = nums[j];
                i++;
            }
            j++;
        }

        return i;
    }
}