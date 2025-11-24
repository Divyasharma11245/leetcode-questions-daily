class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int subsets = 1<<n; //2raised to power n
        for(int i = 0; i<subsets; i++){
            List<Integer> inner = new ArrayList<>();
            for(int j = 0; j<n; j++){ //check if ith bit is set or not
                if((i&(1<<j))!=0){
                    inner.add(nums[j]);
                }
            }
            ans.add(inner);
        }
        return ans;
    }
}