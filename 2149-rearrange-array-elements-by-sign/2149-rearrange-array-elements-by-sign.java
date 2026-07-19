class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
       int posNums[]= new int[n/2];
       int negNums[] = new int[n/2];

        int idx=0;
       for(int i=0; i<n; i++){
        if(nums[i]<0){
            negNums[idx] =nums[i];
            idx++;
        } 
       } 

        idx=0;
       for(int i=0; i<n; i++){
        if(nums[i]>0){
            posNums[idx] =nums[i];
            idx++;
        } 
       } 

       int i = 0;
       int j = 0;
       for(int k = 0; k<n; k++){
        if(k%2==0){
            nums[k] = posNums[i];
            i++;
        }else{
            nums[k] = negNums[j];
            j++;
        }
       }
       return nums;
    }
}