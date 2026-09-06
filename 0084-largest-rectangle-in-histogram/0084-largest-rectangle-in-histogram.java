class Solution {
    private int[] findPrevSmaller(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        for(int i = 0; i<n; i++){
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            ans[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return ans;
    }

        private int[] findNextSmaller(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            ans[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int[] nextSmaller = findNextSmaller(heights);
        int[] prevSmaller = findPrevSmaller(heights);
        int n = heights.length;
        int ans = 0;
        for(int i=0; i<n; i++){
            ans = Math.max(ans, heights[i]*(nextSmaller[i]-prevSmaller[i]-1));
        }
        return ans;
    }
}