class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int i = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));

        while(i<n-1){
            if(intervals[i][1]>=intervals[i+1][0]){
                intervals[i][0] = Math.min(intervals[i][0], intervals[i+1][0]);
                intervals[i][1] = Math.max(intervals[i][1], intervals[i+1][1]);
                for (int j = i + 1; j < n - 1; j++) {
                    intervals[j][0] = intervals[j + 1][0];
                    intervals[j][1] = intervals[j + 1][1];
                }
                
                n--;
            }else{
                 i++;
            }
           
        }
        return Arrays.copyOf(intervals, n);
    }
}