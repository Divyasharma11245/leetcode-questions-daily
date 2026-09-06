class Solution {
        private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i<n; i++){
            while(!st.isEmpty()&&heights[st.peek()]>=heights[i]){
                int nse  = i;
                int ele = st.pop();
                int pse = st.isEmpty()?-1:st.peek();
                maxArea = Math.max(maxArea, heights[ele]*(nse-pse-1));
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int nse = n;
            int ele = st.pop();
            int pse = st.isEmpty()?-1:st.peek();
            maxArea = Math.max(maxArea, heights[ele]*(nse-pse-1));
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){ 
                if(matrix[i][j] == '1'){
                    heights[j]++; 
                    } 
                    else{ 
                        heights[j] = 0; 
                        } 
                    }
            int currSum = largestRectangleArea(heights);
            ans = Math.max(ans, currSum);
        }
        return ans;
    }
}