class Solution {
    public int singleNumber(int[] nums) {
        HashMap <Integer, Integer> map = new HashMap<>();
        int count = 0;
        int ans = 0;
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Set <Integer> set = map.keySet();
        for(int ele: set ){
            if(map.get(ele)==1){
                return ele;
            }
        }
        return -1;
    }
}