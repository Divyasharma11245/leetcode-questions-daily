class Solution {
    private int countSubarray(int[] nums, int k){
        int i = 0; 
        int j = 0;
        int n = nums.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(j<n){
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
            while(map.size()>k){
                map.put(nums[i], map.getOrDefault(nums[i], 0)-1);
                if(map.get(nums[i])==0){
                    map.remove(nums[i]);
                }
                i++;
            }
            
                count+=j-i+1;
            
            j++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countSubarray(nums, k)-countSubarray(nums, k-1);
    }
}