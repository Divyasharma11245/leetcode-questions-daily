class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<n; i++){
            if(i>0 &&nums[i]==nums[i-1]) continue;
            int low = i+1;
            int high = n-1;
            while(low<high){
            int sum = nums[i]+nums[low]+nums[high];
            if(sum>0){
                high--;
            }else if(sum<0){
                low++;
            }else{
                List<Integer> inner = new ArrayList<>();
                inner.add(nums[i]);
                inner.add(nums[low]);
                inner.add(nums[high]);
                list.add(inner);
                low++;
                high--;
                while(low<high&&nums[low]==nums[low-1]) low++;
            }
            }
            
        }
        return list;
    }
}