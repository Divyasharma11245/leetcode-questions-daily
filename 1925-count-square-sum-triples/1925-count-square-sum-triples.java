class Solution {
    public int countTriples(int n) {
        int arr[] = new int[n+1];
        arr[0] = 0;

        for(int i=1; i<=n; i++){
            arr[i] = i*i;
        }

        int count = 0;
        for(int i = 1; i<=n; i++){
            for(int j = i+1; j<=n; j++){
                for(int k = j+1; k<=n; k++){
                    if(arr[i]+arr[j]==arr[k]){
                        count+=2;
                    }
                }
            }
        }
        return count;
    }
}