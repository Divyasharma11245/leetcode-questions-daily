class Solution {
    public int singleNumber(int[] nums) {
        //approach 2 - using bits and counting the number of set bits
        int ans = 0;
        for(int i = 0; i<32; i++){
            int count = 0;
            for(int  j= 0; j<nums.length; j++){
                if((nums[j]&(1<<i))!=0){
                    count++;
                }
            }
            if(count%3==1){
                ans = ans|(1<<i);
            }
        }
        return ans;
    }
}