class Solution {
    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        int leftSum = 0;
        int rightSum = 0;
        int j = n-1;
        int maxSum = 0;
        for(int i =0; i<k; i++){
            leftSum+=nums[i];
            maxSum = leftSum;
        }
        for(int i = k-1; i>=0; i--){
            leftSum-=nums[i];
            rightSum +=nums[j];
            j--;
            int totalSum = leftSum+rightSum;
            maxSum = Math.max(maxSum, totalSum);
        }
        return maxSum;
        
    }
}