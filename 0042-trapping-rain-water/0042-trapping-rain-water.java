class Solution {
    public int trap(int[] height) {
        int n = height.length;
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for(int r = 0; r<n; r++){
            while(!st.isEmpty()&&height[st.peek()]<height[r]){
                int m = st.pop();

                if(st.isEmpty()){
                    break;
                }

                int l = st.peek();
                int h = Math.min(height[l], height[r])-height[m];
                int w = r-l-1;
                ans+=h*w;
            }
            st.push(r);
        }
        return ans;
    }
}