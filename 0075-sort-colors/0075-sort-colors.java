class Solution {
    private void swap(int a, int b, int nums[]){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        int high = n-1;
        int low = 0;
        int mid = 0;
        while(mid<=high){
            if(nums[mid]==0){
                swap(mid, low, nums);
                mid++;
                low++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                swap(mid, high, nums);
                high--;
            }
        }
    }
}