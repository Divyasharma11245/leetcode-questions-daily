class Solution {
    static final long MOD = 1000000007;
    private long power(long x, long exp, long ans) {
        if (exp == 0) {
            return ans;
        }

        if (exp % 2 != 0) {
            ans = (ans * x) % MOD;
        }

        x = (x * x) % MOD;

        return power(x, exp / 2, ans);
    }

    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n/2;
        long ans1 = power(5, even,1);
        long ans2 = power(4, odd,1);
        return (int)((ans1*ans2)%MOD);
    }
}