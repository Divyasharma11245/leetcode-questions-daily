class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int arr[] = new int[n+m];
        int i = 0;
        int j = 0;
        int idx = 0;
        while(i<n&&j<m){
            if(nums1[i]<nums2[j]){
                arr[idx] = nums1[i];
                i++;
            }else{
                arr[idx] = nums2[j];
                j++;
            }
            idx++;
        }
        while(i<n){
            arr[idx] = nums1[i];
            i++;
            idx++;
        }
        while(j<m){
            arr[idx] = nums2[j];
            j++;
            idx++;
        }

        int mid = (arr.length-1)/2;
        double median = 0;
        if(arr.length%2!=0){
            median = arr[mid];
        }else{
            median = (arr[mid]+arr[mid+1])/2.0;
        }

        return median;
    }
}