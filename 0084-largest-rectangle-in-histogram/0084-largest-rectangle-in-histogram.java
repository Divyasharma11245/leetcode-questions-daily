class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int leftSmaller[] = new int[n];
        int rightSmaller[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++){
            while(!st.isEmpty()&&heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                leftSmaller[i] = -1;
            }else{
                leftSmaller[i] = st.peek();
            }
            st.push(i);
        }
        st = new Stack<>();
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty()&&heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                rightSmaller[i] = n;
            }else{
               rightSmaller[i] = st.peek();
            }
            st.push(i);
        }

        int ans = 0;
        for(int i = 0; i<n; i++){
            int width = rightSmaller[i]-leftSmaller[i]-1;
            int currArea = heights[i]*width;
            ans = Math.max(ans, currArea);
        }
        return ans;
    }
}