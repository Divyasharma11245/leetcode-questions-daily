class Solution {
    private int findDays(int[] weights, int mid){
        int sum = 0;
        int days = 1;
        for(int i = 0; i<weights.length; i++){
            sum+=weights[i];
            if(sum>mid){
                sum=weights[i];
                days++;
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i = 0; i<weights.length; i++){
            low = Math.max(weights[i], low);
            high+=weights[i];
        }

        int ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            int orgDays = findDays(weights, mid);
            if(orgDays<=days){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            } 
        }
        return ans;
    }
}