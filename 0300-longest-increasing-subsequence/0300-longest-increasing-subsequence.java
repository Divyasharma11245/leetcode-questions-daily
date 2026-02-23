class Solution {
    public int lengthOfLIS(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i =0; i<nums.length; i++){
            set.add(nums[i]);
        }

        int arr[] = new int[set.size()];
        int idx = 0;
        for(int s: set){
            arr[idx] = s;
            idx++;
        }

        Arrays.sort(arr);

        int n = nums.length;
        int m = arr.length;
        int dp[][] = new int[n+1][m+1];
        for(int i = 0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[0].length; j++){
                if(nums[i-1]==arr[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    int ans1 = dp[i][j-1];
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }
}