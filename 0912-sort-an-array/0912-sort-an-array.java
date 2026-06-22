class Solution {
    private void heapify(int[] arr, int i, int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx = i;
        if(left<size&&arr[left]>arr[maxIdx]) maxIdx = left;
        if(right<size&&arr[right]>arr[maxIdx]) maxIdx = right;
        if(maxIdx!=i){
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for(int i = n/2; i>=0; i--){
            heapify(nums, i, n);
        }

        for(int i = n-1; i>=0; i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums, 0, i);
        }
        return nums;
    }
}