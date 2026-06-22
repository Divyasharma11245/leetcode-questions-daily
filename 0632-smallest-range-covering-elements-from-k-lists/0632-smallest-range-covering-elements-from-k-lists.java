class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        int maxEl = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b) -> a[0] - b[0]);
            int[] resultRange = {-1000000, 1000000};
        for(int i = 0; i<k; i++){
            pq.offer(new int[]{nums.get(i).get(0), i, 0});
            maxEl = Math.max(maxEl, nums.get(i).get(0));


            while(pq.size() == k){
                int curr[] = pq.peek();
                pq.poll();
                int minEl = curr[0];
                int listIdx = curr[1];
                int idx = curr[2];
                if(maxEl-minEl<resultRange[1]-resultRange[0]){
                    resultRange[0] = minEl;
                    resultRange[1] = maxEl;
                }

                if(idx+1<nums.get(listIdx).size()){
                    int nextEl = nums.get(listIdx).get(idx+1);
                    pq.offer(new int[]{nextEl, listIdx, idx+1});
                    maxEl = Math.max(maxEl, nextEl);
                }else{
                    break;
                }
            }
        }
        return resultRange;
    }
}