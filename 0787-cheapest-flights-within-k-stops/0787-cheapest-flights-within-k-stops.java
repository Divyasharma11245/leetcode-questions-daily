class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int dist[] = new int[n];
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<flights.length; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int d = flights[i][2];
            adj.get(u).add(new int[]{v, d});
        }

        Queue<int[]> q = new LinkedList<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        q.add(new int[]{0, 0, src});
        dist[src]  = 0;

        while(!q.isEmpty()){
            int curr[] = q.poll();
            int currStop = curr[0];
            int currDist = curr[1];
            int currNode = curr[2];
            for(int i = 0; i<adj.get(currNode).size(); i++){
                int neighNode = adj.get(currNode).get(i)[0];
                int neighDist = adj.get(currNode).get(i)[1];
                if(dist[neighNode]>currDist+neighDist&&currStop<=k){
                    dist[neighNode] = currDist+neighDist;
                    q.add(new int[]{currStop+1, dist[neighNode], neighNode});
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}