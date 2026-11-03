class Solution {
    class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    class Tuple{
        int stop;
        int dist;
        int node;
        Tuple(int stop, int dist, int node){
            this.stop = stop;
            this.dist = dist;
            this.node = node;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<flights.length; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        int dist[] = new int[n];
        Arrays.fill(dist, (int)1e9);

        Queue<Tuple> q= new LinkedList<>();

        dist[src] = 0;
        q.add(new Tuple(0, 0, src));
        while(!q.isEmpty()){
            Tuple curr = q.poll();
            int currStop = curr.stop;
            int currDist = curr.dist;
            int currNode = curr.node;
            for(int i = 0; i<adj.get(currNode).size(); i++){
                int neigh = adj.get(currNode).get(i).node;
                int neighDist = adj.get(currNode).get(i).dist;
                if(dist[neigh]>neighDist+currDist&&currStop<=k){
                    dist[neigh] = neighDist+currDist;
                    q.add(new Tuple(currStop+1, dist[neigh], neigh));
                }
            }
        }
        if(dist[dst]==(int)1e9) return -1;
        return dist[dst];
    }
}