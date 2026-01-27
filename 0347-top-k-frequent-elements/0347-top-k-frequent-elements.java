class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        List<Integer>bucket[] = new List[nums.length+1];
        
        for(Integer key: map.keySet()){
            int freq = map.get(key);
            if(bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int result[] = new int[k];
        int counter = 0;
        for(int i = bucket.length-1; i>=0&&counter<k; i--){
            if(bucket[i]!=null){
                for(Integer ans: bucket[i]){
                    result[counter++] = ans;
                }
            }
        }
        return result;
   
    }
}