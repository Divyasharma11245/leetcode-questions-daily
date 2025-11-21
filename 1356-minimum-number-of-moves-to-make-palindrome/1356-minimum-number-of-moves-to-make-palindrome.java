class Solution {
     private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int minMovesToMakePalindrome(String s) {
         char[] arr = s.toCharArray();
        int lt = 0;
        int rt = s.length()-1;
        int ans = 0;
        while(lt<rt){
            int l = lt;
            int r = rt;
            while (l < r && arr[l] != arr[r]) {
                r--;
            }
            if(l==r){
                swap(arr, r, r + 1);
                ans++;
                continue;
            }else{
                while(r<rt){
                     swap(arr, r, r + 1);
                    ans++;
                    r++;
                }
                lt++;
                rt--;
            }
        }
        return ans;
    }
}