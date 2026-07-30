class Solution {
    private int maxElement(int[][] mat, int m , int n , int mid){
        int max = mat[0][mid];
        int idx = 0;
        for(int i = 0; i<m; i++){
            if(mat[i][mid]>max){
                max = mat[i][mid];
                idx = i;
            }
        }
        return idx;
    }
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int row = maxElement(mat, m ,n , mid);
            int left = mid>0?mat[row][mid-1]:-1;
            int right = mid<n-1?mat[row][mid+1]:-1;
            if(mat[row][mid]>left&&mat[row][mid]>right) return new int[]{row, mid};
            else if(mat[row][mid]<left) high = mid-1;
            else low = mid+1;
        }
        return new int[] {-1, -1};
    }
}