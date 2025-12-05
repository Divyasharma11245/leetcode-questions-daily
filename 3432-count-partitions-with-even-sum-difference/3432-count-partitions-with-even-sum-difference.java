class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int count = 0;

        for(int i = 0; i<n-1; i++){
            int sum1 = 0;
            for(int j = 0; j<=i; j++){
                sum1+=nums[j];
            }

            int sum2 = 0;
            for(int k = i+1; k<n; k++){
                sum2+=nums[k];
            }
    
            if ((sum1 % 2) == (sum2 % 2)){
                count++;
            }
        }
        
        return count;
    }
}