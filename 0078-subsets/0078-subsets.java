class Solution {
    private void solve(int[] nums, int i, ArrayList<Integer> list, List<List<Integer>> ans){
        if(i>=nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        solve(nums, i+1, list, ans);
        list.remove(list.size()-1);
        solve(nums, i+1, list, ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        solve(nums, 0, list, ans);
        return ans;
    }
}