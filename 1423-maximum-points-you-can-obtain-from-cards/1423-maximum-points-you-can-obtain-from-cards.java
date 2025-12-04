class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lSum = 0;
        int rSum = 0;
        int sum = 0;

        for(int i = 0; i<=  k-1; i++){
            lSum+=cardPoints[i];
        }
        sum = lSum;

        int rightIdx = n-1;
        for(int j = k-1; j>=0; j--){
            lSum-=cardPoints[j];
            rSum+=cardPoints[rightIdx];
            rightIdx--;
            sum = Math.max(sum, (lSum+rSum));
        }



        return sum;

    }
}