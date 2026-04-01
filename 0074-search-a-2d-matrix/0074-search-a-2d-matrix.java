class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int si = 0;
        int ei = n*m-1;
        while(ei>=si){
           int mid = (si+ei)/2;
           int row = mid/m;
           int col = mid%m;
            if(matrix[row][col]==target){
                return true;
            }else if(matrix[row][col]<target){
                si = mid+1;
            }else{
                ei = mid-1;
            }
        }
        return false;
    }
}