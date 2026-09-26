class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        int lastIdx = intervals[0][1];
        int count = 0;
        for(int i = 1; i<n; i++){
            if(intervals[i][0]<lastIdx){
                count++;
                lastIdx = Math.min(lastIdx, intervals[i][1]);
            }else{
                lastIdx = intervals[i][1];
            }
        }
        return count;
    }
}