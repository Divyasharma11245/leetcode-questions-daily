class Solution {
    public int minimumDistance(int[] nums) {
        int n=nums.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        int result = Integer.MAX_VALUE;
        for(int k=0; k<n; k++){
            map.putIfAbsent(nums[k], new ArrayList<>());
            map.get(nums[k]).add(k);

            ArrayList<Integer> arr = map.get(nums[k]);
            if(arr.size()>=3){
                int size = arr.size();
                int dist= arr.get(size - 1) - arr.get(size - 3);
                result = Math.min(result, 2*dist);
            }
        }
        if(result==Integer.MAX_VALUE){
            return -1;
        }
        return result;
    }
}