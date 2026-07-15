class Solution {
    private void merge(int[] nums, int st, int mid, int end){
        ArrayList<Integer> list = new ArrayList<>();
        int i = st;
        int j = mid+1;
        while(i<=mid&&j<=end){
            if(nums[i]<nums[j]){
                list.add(nums[i]);
                i++;
            }else{
                list.add(nums[j]);
                j++;
            }
        }
        while(i<=mid){
            list.add(nums[i]);
                i++;
        }
        while(j<=end){
            list.add(nums[j]);
            j++;
        }

        for(int idx = st; idx<=end; idx++){
            nums[idx] = list.get(idx-st);
        }
        }
    private void mergeSort(int[] nums, int st, int end){
        if(st<end){
            int mid = st+(end-st)/2;
             mergeSort(nums, st, mid);
             mergeSort(nums, mid+1, end);
            merge(nums, st, mid, end);
        }
    }

public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
}