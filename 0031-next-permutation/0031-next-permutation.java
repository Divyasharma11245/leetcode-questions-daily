class Solution {
    private void reverse(int i, int j, int nums[]){
        while(i<=j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int piv = -1;
        for(int i = n-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                piv = i;
                break;
            }
        }
        if(piv==-1){
            reverse(0, n-1, nums);
            return;
        }

        for(int i = n-1; i>=0; i--){
            if(nums[piv]<nums[i]){
                int temp = nums[i];
                nums[i] = nums[piv];
                nums[piv]= temp;
                break;
            }
        }

        int i = piv+1;
        int j = n-1;
        reverse(i, j, nums);
    }
}