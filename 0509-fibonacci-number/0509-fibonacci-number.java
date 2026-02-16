class Solution {
    private int fibUtil(int n, int fib[]){
        if(n==0||n==1){
            return n;
        }
        if(fib[n]!=0){
            return fib[n];
        }
        fib[n] = fibUtil(n-1, fib)+fibUtil(n-2, fib);
        return fib[n];
    }
    public int fib(int n) {
        int fib[] = new int[n+1];
        int ans = fibUtil(n, fib);
        return ans;
    }
}