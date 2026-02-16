class Solution {
    public int fib(int n) {
        int fib[] = new int[n+1];
        fib[0] = 0;
        if(n==0){
            return fib[0];
        }
        fib[1] = 1;
        for(int i = 2; i<=n; i++){
            fib[i]=fib[i-1]+fib[i-2];
        }
        return fib[n];
    }
}