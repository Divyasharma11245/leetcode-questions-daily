class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }

        int target = sum/2;
        int n = nums.length;
        boolean dp[][] = new boolean[n+1][target+1];
        for(int i = 0; i<dp.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i<dp.length; i++){
            for(int j = 0; j<dp[0].length; j++){
                int v = nums[i-1];
                if(v<=j&&dp[i-1][j-v]==true){
                    dp[i][j] = true;
                }else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][target];
    }
}