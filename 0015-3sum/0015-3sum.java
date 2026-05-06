class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> unique = new HashSet<>();
        for(int i =0; i<n; i++){
            int target = -nums[i];
            Set<Integer> s = new HashSet<>();
            for(int j = i+1; j<n; j++){
                int third = target-nums[j];
                if(s.contains(third)){
                    List<Integer> inner = new ArrayList<>();
                    inner.add(nums[i]);
                    inner.add(nums[j]);
                    inner.add(third);
                    Collections.sort(inner);
                    if(unique.add(inner)){  
                        list.add(inner);
                    }
                }
                s.add(nums[j]);
            }
        }
        return list;
    }
}