class Solution {
    private boolean binarySearch(int s, int e, int row, int matrix[][], int target){
        int n = matrix[0].length;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(target==matrix[row][mid]){
                return true;
            }else if(target<matrix[row][mid]){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int sr = 0;
        int er = m-1;
        while(sr<=er){
            int midR = sr+(er-sr)/2;
            if(target>=matrix[midR][0]&&target<=matrix[midR][n-1]){
                return binarySearch(0, n-1, midR, matrix, target);
            }else if(target<matrix[midR][0]){
                er=midR-1;
            }else{
                sr=midR+1;
            }
        }
        return false;
    }
}