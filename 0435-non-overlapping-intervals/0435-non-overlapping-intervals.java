class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int arr[][] = new int[intervals.length][3];

        for(int i = 0; i<intervals.length; i++){
            arr[i][0] = i;
            arr[i][1] = intervals[i][0];
            arr[i][2] = intervals[i][1];
        }

        Arrays.sort(arr, Comparator.comparingDouble(o->o[2]));

        int lastGreater = arr[0][2];
        int count = 1;
        for(int i = 1; i<arr.length; i++){
            if((arr[i][1]>=lastGreater)){
                count++;
                lastGreater = arr[i][2];
            }
        }
        return arr.length-count;
    }
}