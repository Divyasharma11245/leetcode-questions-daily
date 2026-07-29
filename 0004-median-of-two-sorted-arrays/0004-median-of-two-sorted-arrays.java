class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int temp[] = new int[m+n];
        int i = 0;
        int j = 0;
        int idx = 0;
        while(i<m&&j<n){
            if(nums1[i]<=nums2[j]){
                temp[idx] = nums1[i];
                idx++;
                i++;
            }else{
                temp[idx] = nums2[j];
                idx++;
                j++;
            }
        }
        while(i<m){
            temp[idx] = nums1[i];
                idx++;
                i++;
        }
        while(j<n){
            temp[idx] = nums2[j];
                idx++;
                j++;
        }

        if((m+n)%2!=0){
            return (double)temp[(m+n)/2];
        }

        double ans = ((double)temp[(m+n)/2]+(double)temp[(m+n)/2-1])/2.0;
        return ans;

    }
}