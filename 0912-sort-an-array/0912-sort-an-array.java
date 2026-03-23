class Solution {
    private void heapify(int nums[], int i, int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx = i;
        if(left<size&&nums[left]>nums[maxIdx]){
            maxIdx = left;
        }
        if(right<size&&nums[right]>nums[maxIdx]){
            maxIdx = right;
        }

        if(maxIdx!=i){
            int temp = nums[i];
            nums[i] = nums[maxIdx];
            nums[maxIdx] = temp;

            heapify(nums, maxIdx, size);
        }
    }
    private void heapSort(int nums[]){
        int n = nums.length;
        for(int i = n/2; i>=0; i--){
            heapify(nums, i, n);
        }

        for(int i = n-1; i>0; i--){
            //swap
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            heapify(nums, 0, i);
        }
    }
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }
}