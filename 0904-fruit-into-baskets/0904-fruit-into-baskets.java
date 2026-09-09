class Solution {
    public int totalFruit(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(r<n){
            map.put(arr[r], map.getOrDefault(arr[r], 0)+1);
            if(map.size()>2){
                while(map.size()>2){
                    map.put(arr[l], map.getOrDefault(arr[l], 0)-1);
                    if(map.get(arr[l])==0){
                        map.remove(arr[l]);
                    }
                    l++;
                }
            }
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}