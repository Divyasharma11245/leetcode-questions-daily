class Solution {
    private int solve(int[] nums, int i, int currSum, int target, HashMap<String, Integer> map){
        if(i==nums.length) return currSum == target ? 1 : 0;

        String key = i + "-" + currSum;

        if(map.containsKey(key)){
            return map.get(key);
        }

        int add = solve(nums, i+1, currSum+nums[i], target, map);
        int sub = solve(nums, i+1, currSum-nums[i], target, map);

        map.put(key, add + sub);
        return map.get(key);
    }
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> map = new HashMap<>();
        return solve(nums, 0, 0, target, map);
        
    }
}