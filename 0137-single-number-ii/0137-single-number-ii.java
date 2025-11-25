class Solution {
    public int singleNumber(int[] nums) {
        //approach 1 - using map
        HashMap <Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        Set<Integer> set = map.keySet();

        for(int ele: set){
            if(map.get(ele)==1){
                return ele;
            }
        }
        return -1;
    }
}