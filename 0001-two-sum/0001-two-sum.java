class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int ans[] = new int[2];
        for(int i = 0; i<n; i++){
            int first = nums[i];
            int second = target-first;
            if(map.containsKey(second)){
                ans[0] = map.get(second);
                ans[1] = i;
                break;
            }else{
                map.put(first, i);
            }
        }
        return ans;
    }
}