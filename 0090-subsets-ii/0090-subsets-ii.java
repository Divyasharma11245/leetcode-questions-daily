class Solution {
    private void  solve(int[] nums, int idx, ArrayList<Integer> list, List<List<Integer>> ans){
        
            ans.add(new ArrayList<>(list));
            
        for(int i = idx; i<nums.length; i++){
            if(i>idx&&nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            solve(nums, i+1, list, ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, 0, list, ans);
        return ans;
    }
}