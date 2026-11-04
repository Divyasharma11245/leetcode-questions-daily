class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<times.length; i++){
            adj.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]);
        int dist[] = new int[n+1];
        pq.add(new int[]{0, k});
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int currD = curr[0];
            int currN = curr[1];
            if(currD > dist[currN]) {
                continue;
            }
            for(int i = 0; i<adj.get(currN).size(); i++){
                int neighN = adj.get(currN).get(i)[0];
                int neighD = adj.get(currN).get(i)[1];
                if(dist[neighN]>neighD+currD){
                    dist[neighN] = neighD+currD;
                    pq.add(new int[]{dist[neighN], neighN});
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i<dist.length; i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}