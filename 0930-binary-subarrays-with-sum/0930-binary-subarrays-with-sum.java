class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int prefix[] = new int[n];
        prefix[0] = nums[0];
        for(int i = 1; i<n; i++){
            prefix[i] = prefix[i-1]+nums[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0,1);

        for(int j = 0; j<prefix.length; j++){
            int val = prefix[j]-goal;
            if(map.containsKey(val)){
                count+=map.get(val);
            }
                map.put(prefix[j], map.getOrDefault(prefix[j], 0)+1);
            
        }

        return count;
    }
}