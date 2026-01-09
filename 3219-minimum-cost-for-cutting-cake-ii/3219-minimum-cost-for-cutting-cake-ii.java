class Solution {
    private void reverse(int[] arr) {
    int l = 0, r = arr.length - 1;
    while (l < r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        l++;
        r--;
    }
}
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        reverse(horizontalCut);
        reverse(verticalCut);

        int hp = 1;
        int vp = 1;
        int h = 0;
        int v = 0;
        long cost = 0;

        while(h<horizontalCut.length &&v<verticalCut.length){
            if(horizontalCut[h]>=verticalCut[v]){
                cost+= (long)(horizontalCut[h]*vp);
                hp++;
                h++;
            }else{
                cost+= (long)(verticalCut[v]*hp);
                vp++;
                v++;
            }
        }

        while(v<verticalCut.length){
            cost+= (long)(verticalCut[v]*hp);
                vp++;
                v++;
        }

        while(h<horizontalCut.length){
             cost+= (long)(horizontalCut[h]*vp);
                hp++;
                h++;
        }

        return cost;
    }
}