class Solution {
    public int countPermutations(int[] complexity) {
        long M = 1000000007;
        long result = 1;

        for(int i = 1; i<complexity.length; i++){
            if(complexity[i]<=complexity[0]){
                return 0;
            }else{
                result = (result*i)%M;
            }
            
        }
        return (int)result;
    }
}