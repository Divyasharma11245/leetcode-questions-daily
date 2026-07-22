class Solution {
    private void merge(int st, int mid, int end, int[] nums){
        int temp[] = new int[end-st+1];
        int i = st;
        int j = mid+1;
        int idx  = 0;
        while(i<=mid&&j<=end){
            if(nums[i]<=nums[j]){
                temp[idx] = nums[i];
                idx++;
                i++;
            }else{
                temp[idx] = nums[j];
                idx++;
                j++;
            }
        }
        while(i<=mid){
            temp[idx] = nums[i];
            idx++;
            i++;
        }
        while(j<=end){
            temp[idx] = nums[j];
            idx++;
            j++;
        }
        for(int k = st; k <= end; k++){
        nums[k] = temp[k - st];
    }
    }
    private int countPairs(int st, int mid, int end, int[] nums){
        int right = mid+1;
        int count = 0;
        for(int  i=st; i<=mid; i++){
            while(right<=end&&nums[i]>2L*nums[right]){
                right++;
            }
            count+=right-(mid+1);
        }
        return count;
    }
    private int mergeSort(int st, int end, int nums[]){
        int count =0;
        if(st<end){
            int mid = st+(end-st)/2;

            count+=mergeSort(st, mid, nums);
            count+=mergeSort(mid+1, end, nums);
            count+=countPairs(st, mid, end, nums);
            merge(st, mid, end, nums);
            return count;
        }
        return 0;
    }
    public int reversePairs(int[] nums) {
        return mergeSort(0, nums.length-1, nums);
    }
}