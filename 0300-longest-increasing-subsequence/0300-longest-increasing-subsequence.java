class Solution {
    public int lengthOfLIS(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            set.add(nums[i]);
        }

        int arr[] = new int[set.size()];
        int i = 0;
        for(int num:set){
            arr[i] =num;
            i++;
        }

        Arrays.sort(arr);

        int m = arr.length;
        int n = nums.length;
        int dp[][] = new int[m+1][n+1];
        for(int k=1; k<=m; k++){
            for(int j = 1; j<=n; j++){
                if(arr[k-1]==nums[j-1]){
                    dp[k][j] = dp[k-1][j-1]+1;
                }else{
                    int ans1 = dp[k-1][j];
                    int ans2 = dp[k][j-1];
                    dp[k][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[m][n];
    }
}