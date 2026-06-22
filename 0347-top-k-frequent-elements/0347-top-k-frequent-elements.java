class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List bucket[] = new List[n+1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for(int key: map.keySet()){
            int freq = map.get(key);
            if(bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int res[] = new int[k];
        int count = 0;
        for(int i = bucket.length-1; i>=0&&count<k; i--){
            if(bucket[i]!=null){
                for(int j = 0; j<bucket[i].size(); j++){
                    res[count++] = (int) bucket[i].get(j);
                }
            }
        }
        return res;
    }
}