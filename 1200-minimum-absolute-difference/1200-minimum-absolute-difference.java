class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int minDif = Integer.MAX_VALUE;
         List<List<Integer>> l = new ArrayList<>();
        Arrays.sort(arr);
        for(int i = 1; i<arr.length; i++){
            minDif=Math.min(minDif,Math.abs(arr[i-1]-arr[i]));
        }
        for(int i = 1; i<arr.length; i++){
            List<Integer> innerList = new ArrayList<>();
            if(Math.abs(arr[i-1]-arr[i])==minDif){
                innerList.add(arr[i-1]);
                innerList.add(arr[i]);
                l.add(innerList);
            }
            
        }
        return l;
    }
}