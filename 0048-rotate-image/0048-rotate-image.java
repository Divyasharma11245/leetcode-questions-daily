class Solution {
    private void reverse(int[] nums){
        int n = nums.length;
        for(int i = 0; i<n/2; i++){
           int temp = nums[i];
           nums[i] = nums[n-i-1];
           nums[n-i-1] = temp;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int[] nums: matrix){
            reverse(nums);
        }
    }
}