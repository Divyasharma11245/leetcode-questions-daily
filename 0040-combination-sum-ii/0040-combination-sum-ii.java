class Solution {
    private void solve(int[] nums, int target, int idx, ArrayList<Integer> list, List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = idx; i<nums.length; i++){
            if(i>idx&&nums[i]==nums[i-1]) continue;
            if(nums[i]>target) break;
            list.add(nums[i]);
            solve(nums, target-nums[i], i+1, list, ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, target, 0, list, ans);
        return ans;
    }
}