class Solution {
        private int[] findPrevSmaller(int arr[]){
        int n = arr.length;
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++){
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            ans[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return ans;
    }
    private int[] findNextSmaller(int[] arr) {
    int n = arr.length;
    int[] ans = new int[n];
    Stack<Integer> st = new Stack<>();
    for (int i = n - 1; i >= 0; i--) {
        while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
            st.pop();
        }
        ans[i] = st.isEmpty() ? n : st.peek();
        st.push(i);
    }
    return ans;
}

    private int[] findNextGreater(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i  = n-1; i>=0; i--){
            while(!st.isEmpty()&&arr[st.peek()] < arr[i]) {
            st.pop();
        }
        ans[i] = st.isEmpty() ? n : st.peek();
        st.push(i);
    }
    return ans;
    }

        private int[] findPrevGreater(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++){
            while(!st.isEmpty()&&arr[st.peek()] <= arr[i]) {
            st.pop();
        }
        ans[i] = st.isEmpty() ? -1 : st.peek();
        st.push(i);
    }
    return ans;
    }

    private long sumMin(int[] arr){
        int n = arr.length;
        int prevSmaller[] = findPrevSmaller(arr);
        int nextSmaller[] = findNextSmaller(arr);
        long ans = 0;
        for(int i = 0; i<n; i++){
            int left = i-prevSmaller[i];
            int right = nextSmaller[i]-i;
            long value =  (long) arr[i] * left * right;
            ans = (ans+value);
        }
        return ans;
    }

    private long sumMax(int[]arr){
        int n = arr.length;
        int prevSmaller[] = findPrevGreater(arr);
        int nextSmaller[] = findNextGreater(arr);
        long ans = 0;
        for(int i = 0; i<n; i++){
            int left = i-prevSmaller[i];
            int right = nextSmaller[i]-i;
            long value =  (long) arr[i] * left * right;
            ans = (ans+value);
        }
        return ans;
    }

    public long subArrayRanges(int[] nums) {
        return sumMax(nums)-sumMin(nums);
    }
}