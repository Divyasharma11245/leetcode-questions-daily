class Solution {
    private boolean binarySearch(int[] arr, int target){
        int si = 0;
        int ei = arr.length-1;
        while(ei>=si){
           int mid = (si+ei)/2;
            if(arr[mid]==target){
                return true;
            }else if(arr[mid]<target){
                si = mid+1;
            }else{
                ei = mid-1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int []arr: matrix){
            if(binarySearch(arr, target)){
                return true;
            }
        }
        return false;
    }
}