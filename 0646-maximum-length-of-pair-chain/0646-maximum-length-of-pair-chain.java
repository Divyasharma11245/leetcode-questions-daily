class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingDouble(o->o[1]));

        int chainLength = 1; //ist wale ko to inlcude krrliya
        int chainEnd = pairs[0][1];

        for(int i = 1; i<pairs.length; i++){
            if(chainEnd<pairs[i][0]){
                chainLength++;
                chainEnd = pairs[i][1];
            }
        }

        return chainLength;
    }
}