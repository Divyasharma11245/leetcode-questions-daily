class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(int key:map.keySet()){
            if(map.get(key)>n/3){
                list.add(key);
            }
        }
        return list;
    }
}