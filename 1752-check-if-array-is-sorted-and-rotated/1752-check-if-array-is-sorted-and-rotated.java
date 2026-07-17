class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int[] temp = nums.clone();
        Arrays.sort(nums);
        for(int j = 0; j<n; j++){
            boolean isSorted = true;
            for(int i = 0; i<n; i++){
                if(nums[i]!=temp[(i+j)%n]){
                     isSorted = false;
                     break;
                }
            }
            if(isSorted==true) return true;
        }
    return false;
    }
}