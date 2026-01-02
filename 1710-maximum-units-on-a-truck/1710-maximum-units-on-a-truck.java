class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
       Arrays.sort(boxTypes, (a,b)-> b[1]-a[1]);

    int finalVal = 0;
    for(int i = 0; i<boxTypes.length; i++){
       
       int count = Math.min(truckSize, boxTypes[i][0]);
        finalVal += boxTypes[i][1]*count;
        truckSize -=  count;

        if(truckSize==0) break;
       }
    
    return finalVal;
}
}