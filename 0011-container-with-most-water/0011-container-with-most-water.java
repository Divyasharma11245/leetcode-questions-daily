class Solution {
    public int maxArea(int[] height) {
        int lp = 0;
        int rp = height.length-1;
        int ans = 0;
        while(lp<rp){
            int width = rp-lp;
            int ht = Math.min(height[lp], height[rp]);
            ans = Math.max(ans, ht*width);
            if (height[lp]<height[rp])lp++;
            else rp--;
        }
        return ans;
    }
}