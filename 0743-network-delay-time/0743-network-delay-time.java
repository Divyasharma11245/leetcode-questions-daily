class Solution {
    public int networkDelayTime(int[][] time, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int dist[] = new int[n+1];
        for(int i = 0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<time.length; i++){
            int u = time[i][0];
            int v = time[i][1];
            int d = time[i][2];
            adj.get(u).add(new int[]{v, d});
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{0, k});
        dist[k]=0;
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int currDist = curr[0];
            int currNode = curr[1];
            for(int i = 0; i<adj.get(currNode).size(); i++){
                int neigh = adj.get(currNode).get(i)[0];
                int neighDist = adj.get(currNode).get(i)[1];
                if(dist[neigh]>neighDist+currDist){
                    dist[neigh]=neighDist+currDist;
                    q.add(new int[]{dist[neigh], neigh});
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