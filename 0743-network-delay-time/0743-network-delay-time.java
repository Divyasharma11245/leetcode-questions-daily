class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        int dist;
        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist-p2.dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<Pair>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph[u].add(new Pair(v, w));
        }

        int dist[] = new int[n+1];
        for(int i = 0; i<dist.length; i++){
            if(i!=k){
                dist[i]=Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        pq.add(new Pair(k, 0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int d = curr.dist;
            if (d > dist[node]) continue;

            for (int i = 0; i < graph[node].size(); i++) {
                Pair neigh = graph[node].get(i);

                if (dist[node] + neigh.dist < dist[neigh.node]) {
                    dist[neigh.node] = dist[node] + neigh.dist;
                    pq.add(new Pair(neigh.node, dist[neigh.node]));
                }   
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}