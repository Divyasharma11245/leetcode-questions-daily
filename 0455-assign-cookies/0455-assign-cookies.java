class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int left = 0;
        int right = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(right<s.length &&left<g.length){
            if(s[right]>=g[left]){
                left++;
            }
            right++;
        }
        return left;
    }
}