class Solution {
    List<List<Integer>> finalList = new ArrayList<>();
    private void solve(int[] nums, int target, int i, int sum, ArrayList<Integer> list){
        if (sum == target) {
            finalList.add(new ArrayList<>(list));
            return;
        }

        if (i >= nums.length || sum > target) {
            return;
        }
        sum+=nums[i];
        list.add(nums[i]);
        solve(nums, target, i, sum, list);
        
        sum-=nums[i];
        list.remove(list.size() - 1);
        solve(nums, target, i+1, sum, list);
        }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        solve(nums, target, 0, 0, list);
        return finalList;
    }
}