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
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int prevSmaller[] = findPrevSmaller(arr);
        int nextSmaller[] = findNextSmaller(arr);
        long ans = 0;
        long MOD = 1000000007;
        for(int i = 0; i<n; i++){
            int left = i-prevSmaller[i];
            int right = nextSmaller[i]-i;
            long value = (arr[i] * left % MOD) * right % MOD;
            ans = (ans+value)%MOD;
        }
        return (int)ans;
    }
}