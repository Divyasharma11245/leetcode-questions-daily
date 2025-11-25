class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        int arr[] = new int[2];
        int idx = 0;
        Set<Integer> set = map.keySet();
        for(int ele: set){
            if(map.get(ele)==1){
                arr[idx++] = ele;
            }
        }
        return arr;
    }
}