class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        //find sum
        long  sum = 0;
        for(int i = 0; i<n; i++){
            sum+=nums[i];
        }

        //find remainder
        int rem = (int)(sum % p); ;

        if(rem==0){
            return 0;
        }

       //find subarray
       HashMap<Integer, Integer> hm = new HashMap<>();

       hm.put(0, -1);
        int ans = n;
        int prefix = 0;
       for(int i = 0; i<n; i++){
        prefix = (prefix + nums[i]) % p;
       
        int key = (prefix-rem+p)%p;
      
        if(hm.containsKey(key)){
             ans = Math.min(ans, i - hm.get(key));
        }
        hm.put(prefix, i);
       }
       
        return ans == n ? -1 : ans;
    }
}