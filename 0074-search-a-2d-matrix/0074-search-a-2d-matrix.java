class Solution {
    private boolean search(int[][] matrix, int target, int row){
        int n = matrix[0].length;
        int st = 0;
        int end = n-1;
        while(st<=end){
            int mid = st+(end-st)/2;
            if(target==matrix[row][mid]){
                return true;
            }else if(target>matrix[row][mid]){
                st=mid+1;;
            }else{
                end = mid-1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int startRow = 0;
        int endRow = m-1;
        while(startRow<=endRow){
            int mid = startRow+(endRow-startRow)/2;
            if(target>=matrix[mid][0]&&target<=matrix[mid][n-1]){
                return search(matrix, target, mid);
            }else if(target>=matrix[mid][n-1]){
                startRow = mid+1;
            }else{
                endRow = mid-1;
            }
        }
        return false;
    }
}