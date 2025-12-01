class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long low = 0;
        long high = 0;
        
        // Calculate total battery minutes
        for(int b : batteries) {
            high += b;
        }
        
        high /= n; // Maximum possible time upper bound
        
        long ans = 0;
        
        while(low <= high) {
            long mid = low + (high - low) / 2;
            
            if(canRunAll(n, batteries, mid)) {
                ans = mid;       // mid is feasible, try higher
                low = mid + 1;
            } else {
                high = mid - 1;  // mid not feasible, try lower
            }
        }
        
        return ans;
    }
    
    // Check if all n computers can run for 'time' minutes
    private boolean canRunAll(int n, int[] batteries, long time) {
        long total = 0;
        for(int b : batteries) {
            total += Math.min(b, time); // contribution from each battery
        }
        return total >= n * time;
    }
}