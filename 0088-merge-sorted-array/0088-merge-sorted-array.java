class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m+n-1;
        int  i = m-1;
        int j = n-1;
        while(idx>=0&&j>=0&&i>=0){
            if(nums2[j]>=nums1[i]){
                nums1[idx] = nums2[j];
                idx--;
                j--;
            }else{
                nums1[idx] = nums1[i];
                idx--;
                i--;
            }
        }
        while(j>=0){
            nums1[idx] = nums2[j];
            idx--;
            j--;
        }
        while(i>=0){
            nums1[idx] = nums1[i];
            idx--;
            i--;
        }
    }
}