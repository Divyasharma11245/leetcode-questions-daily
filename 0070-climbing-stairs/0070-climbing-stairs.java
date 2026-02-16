class Solution {
    private int stepsUtil(int n, int steps[]){
        if(n==1||n==2||n==3){
            return n;
        }
        if(steps[n]!=0){
            return steps[n];
        }
        steps[n] =  stepsUtil(n-1, steps)+stepsUtil(n-2, steps);
        return steps[n];
    }
    public int climbStairs(int n) {
       int steps[] = new int[n+1];
       int finalAns = stepsUtil(n, steps);
       return finalAns;
    }
}