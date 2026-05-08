class Solution {
    private void swap(int i , int j , int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int i , int j, int nums[]){
        while(i<=j){
            swap(i, j, nums);
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;
        for(int  i =n-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                pivot = i;
                break;
            }
        }
        if(pivot==-1){
            reverse(pivot+1, n-1, nums);
        }else{
            for(int i=n-1; i>pivot; i--){
                if(nums[i]>nums[pivot]){
                    swap(i, pivot, nums);
                    break;
                }
            }
            reverse(pivot+1, n-1, nums);
        }
    }
}