class Solution {
    private boolean possible(int[] bloomDay, int days, int m, int k){
        int count = 0;
        int bloom = 0;
        for(int i = 0; i<bloomDay.length; i++){
            if(bloomDay[i]<=days){
                count++;
            }else{
               bloom+=(count/k);
               count = 0; 
            }
        }
        bloom+=(count/k);
        if(bloom>=m) return true;
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i = 0; i<bloomDay.length; i++){
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }
        int ans = -1;
        if(bloomDay.length<(long)m*k) return ans;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(possible(bloomDay, mid, m, k)==true){
                ans = mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}