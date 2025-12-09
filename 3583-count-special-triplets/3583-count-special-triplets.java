class Solution {
    public int specialTriplets(int[] nums) {
        long  M = 1000000007;
        int res = 0;

        HashMap<Integer, Integer> leftMap = new HashMap<>();
        HashMap<Integer, Integer> rightMap = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            rightMap.put(nums[i], rightMap.getOrDefault(nums[i], 0)+1);
        }


        for(int j = 0; j<nums.length; j++){
            rightMap.put(nums[j], rightMap.get(nums[j]) - 1);
            int left = leftMap.getOrDefault(nums[j] * 2, 0);
            int right = rightMap.getOrDefault(nums[j] * 2, 0);
            res = (int)((res + ((long)left * right) % M) % M);
            leftMap.put(nums[j], leftMap.getOrDefault(nums[j], 0)+1);
        }
        return res;
    }
}