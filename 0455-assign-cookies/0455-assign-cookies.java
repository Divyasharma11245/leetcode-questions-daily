class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int m = g.length;
        int n = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int l = 0;
        int r = 0;
        while(l<m&&r<n){
            if(s[r]>=g[l]){
                l++;
                ans++;
                r++;
            }else{
                r++;
            }
            
        }
        return ans;
    }
}