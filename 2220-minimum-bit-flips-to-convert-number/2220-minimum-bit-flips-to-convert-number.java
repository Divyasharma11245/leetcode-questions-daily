class Solution {
    public int minBitFlips(int start, int goal) {
        if(start==goal) return 0;
       int n = start^goal;
       int count = 0;
       while(n!=1){
        if((n&1)==1) count++;
        n=n/2;
       } 
       if(n==1) count++;
       return count;
    }
}