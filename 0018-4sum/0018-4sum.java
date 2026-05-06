class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        ArrayList<List<Integer>>list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<n; i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            for(int j = i+1; j<n; j++){
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                int low = j+1;
                int high = n-1;
                while(low<high){
                    long sum = (long)nums[i]+nums[j]+nums[low]+nums[high];
                    if(sum<target) low++;
                    else if(sum>target) high--;
                    else{
                        List<Integer> inner = new ArrayList<>();
                        inner.add(nums[i]);
                        inner.add(nums[j]);
                        inner.add(nums[low]);
                        inner.add(nums[high]);
                        list.add(inner);
                        low++;
                        high--;
                        while(low<high&&nums[low]==nums[low-1]) low++;
                        while(low<high&&nums[high]==nums[high+1]) high--;
                    }
                }
            }
        }
        return list;
    }
}