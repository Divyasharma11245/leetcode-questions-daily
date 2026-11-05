class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod=1_000_000_007;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b)-> Long.compare(a[0],b[0]));
        int ways[] = new int[n];
        long dist[] = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<roads.length; i++){
                int u = roads[i][0];
                int v = roads[i][1];
                int wt = roads[i][2];

                adj.get(u).add(new int[]{v, wt});
                adj.get(v).add(new int[]{u, wt});
        }

        pq.add(new long[]{0, 0});
        while(!pq.isEmpty()){
            long curr[] = pq.poll();
            long currD = curr[0];
            int currN = (int)curr[1];
            if(currD > dist[currN]){
                continue;
            }
            for(int i = 0; i <adj.get(currN).size(); i++){
                int neighN = adj.get(currN).get(i)[0];
                int neighD = adj.get(currN).get(i)[1];
                if(dist[neighN]>neighD+currD){
                    dist[neighN] = neighD+currD;
                    pq.add(new long[]{dist[neighN], neighN});
                    ways[neighN] = ways[currN];
                }else if(neighD+currD==dist[neighN]){
                    ways[neighN] = (ways[neighN]+ways[currN])%mod;
                }
            }
        }
        return ways[n-1];
    }
}