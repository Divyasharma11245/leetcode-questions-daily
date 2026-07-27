class Solution {
    private long remainingTime(int[] piles, int time){
        long ans = 0;
        for(int i = 0; i<piles.length; i++){
            ans += (piles[i] + time - 1) / time;
        }
        return ans;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<piles.length; i++){
            max = Math.max(piles[i], max);
        }
        int low = 1;
        int high = max;
        int ans = Integer.MIN_VALUE;
        while(low<=high){
            int mid = low+(high-low)/2;
            long time = remainingTime(piles, mid);
            if(time<=h){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}