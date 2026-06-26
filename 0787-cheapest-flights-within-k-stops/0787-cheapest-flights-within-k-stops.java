class Solution {
    class Edge{
        int u;
        int v; 
        int wt;
        Edge(int u, int v, int wt){
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    class Info{
            int src;
            int cost;
            int stops;
            Info(int src, int c, int st){
                this.src = src;
                this.cost = c;
                this.stops = st;
            }
    }

    private void createGraph(int[][] flights, ArrayList<Edge> graph[]){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<flights.length; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(u, v, wt);
            graph[u].add(e);
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        int dist[] = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr.stops>k) break;
            for(int i = 0; i<graph[curr.src].size(); i++){
                Edge neigh = graph[curr.src].get(i);
                if(curr.cost+neigh.wt<dist[neigh.v]){
                    dist[neigh.v] = curr.cost+neigh.wt;
                    q.add(new Info(neigh.v, dist[neigh.v], curr.stops + 1));
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}