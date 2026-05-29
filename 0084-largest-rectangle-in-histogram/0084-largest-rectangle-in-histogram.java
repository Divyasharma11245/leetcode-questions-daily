class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int left[] = new int[n];
        int right[] = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i = n-1; i>=0; i--){
            while(!s.isEmpty()&&heights[s.peek()]>=heights[i]){
                s.pop();
            }
            right[i]=s.isEmpty()?n:s.peek();
            s.push(i);
        }
        s=new Stack<>();
        for(int i =0; i<n; i++){
            while(!s.isEmpty()&&heights[s.peek()]>=heights[i]){
                s.pop();
            }
            left[i]=s.isEmpty()?-1:s.peek();
            s.push(i);
        }

        int maxAns = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            int currArea = (right[i]-left[i]-1)*heights[i]; 
            maxAns = Math.max(currArea, maxAns);
        }
        return maxAns;
    }
}