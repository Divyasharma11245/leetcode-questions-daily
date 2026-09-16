class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        ArrayList[] bucket = new ArrayList[n+1];

        for(int key: map.keySet()){
            int freq = map.get(key);
            if(bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
                
            }
            bucket[freq].add(key);
        }

        int res[] = new int[k];
        int count = 0;
        for(int i = n; i>=0&&count<k; i--){
            if(bucket[i]!=null){
                for(int j = 0; j<bucket[i].size(); j++){
                    res[count] = (int)bucket[i].get(j);
                    count++;
                }
            }
        }
        return res;
    }
}