class Solution {
    public int[][] insert(int[][] arr, int[] newInterval) {
        int n = arr.length;
        int i = 0;
        int idx=0;
        int res[][] = new int[n+1][2];
        while(i<n&&arr[i][1]<newInterval[0]){
            res[idx] = arr[i];
            i = i+1;
            idx++;
        }

        while(i<n&&arr[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(arr[i][0], newInterval[0]);
            newInterval[1] = Math.max(newInterval[1], arr[i][1]);
            i++;
        }
        res[idx] = newInterval;
        idx++;

        while(i<n){
            res[idx] = arr[i];
            i = i+1;
            idx++;
        }
        return Arrays.copyOf(res, idx);
    }
}