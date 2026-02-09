class Solution {
    class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt){
            this.src=src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    class Info{
        int v;
        int cost;
        int stops;
        public Info(int v, int cost, int stops){
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i =0; i<flights.length; i++){
            int sorc = flights[i][0];
            int dest = flights[i][1];
            int cost = flights[i][2];

            graph[sorc].add(new Edge(sorc, dest, cost));
        }

        int dist[] = new int[n];
        for(int i = 0; i<dist.length; i++){
            if(src!=i){
                dist[i]=Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()){
            Info curr = q.poll();
            if(curr.stops>k){
                continue;
            }
            for(int i = 0; i<graph[curr.v].size(); i++){
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if(curr.cost+wt<dist[v]&&curr.stops<=k){
                    dist[v] = curr.cost+wt;
                    q.add(new Info(v, dist[v], curr.stops+1));
                }
            } 
        }

        if(dist[dst]==Integer.MAX_VALUE){
            return -1;
        }else{
            return dist[dst];
        }
    }
}