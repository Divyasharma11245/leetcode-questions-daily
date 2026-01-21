class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List <Integer> list = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>(
             (a, b) -> {
                int diff = Math.abs(b - x) - Math.abs(a - x);
                if (diff == 0) {
                    return b - a; 
                }
                return diff;
            } 
        );

        for(int i = 0; i<arr.length; i++){
            q.add(arr[i]);
            if(q.size()>k){
                q.remove();
            }
        }

        while(!q.isEmpty()){
            list.add(q.remove());
        }

        Collections.sort(list);
        return list;
    }
}