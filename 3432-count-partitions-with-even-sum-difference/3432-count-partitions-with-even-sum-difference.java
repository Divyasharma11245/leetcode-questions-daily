class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int count = 0;
        int tSum = 0;

        for(int i = 0; i<n; i++){
            tSum+=nums[i];
        }

        int sum1 = 0;
        for(int i = 0; i<n-1; i++){
            sum1 += nums[i];
           int sum2 = tSum-sum1;
    
            if ((sum1 % 2) == (sum2 % 2)){
                count++;
            }
        }
        
        return count;
    }
}