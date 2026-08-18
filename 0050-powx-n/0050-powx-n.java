class Solution {
    private double power(double x, long exp, double ans){
        if(exp==0) return ans;
        if(exp%2!=0) ans*=x;
        return power(x*x, exp/2, ans);
    }
    public double myPow(double x, int n) {
        long exp = n;
        if(exp <0){
            x = 1/x;
            exp=-exp;
        }

        return power(x, exp, 1);
    }
}