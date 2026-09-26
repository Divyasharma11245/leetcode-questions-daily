class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int idx = 0;
        int res[][] = new int[n][2];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        res[0] = intervals[0];

        for(int i = 1; i<n; i++){
            if(intervals[i][0]<=res[idx][1]){
                res[idx][0] = Math.min(res[idx][0], intervals[i][0]);
                res[idx][1] = Math.max(res[idx][1], intervals[i][1]);
            }else{
                idx++;
                res[idx] = intervals[i];
               
            }
        }
        return Arrays.copyOf(res, idx+1);
    }
}