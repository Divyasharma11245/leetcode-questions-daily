class Solution {
    private boolean hasPath(ArrayList<ArrayList<Integer>> adj, int source, int destination, boolean[]vis){
        if(source==destination){
            return true;
        }
        vis[source]=true;
        for (int next : adj.get(source)) {
            if (!vis[next]) {
                if (hasPath(adj, next, destination, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]); 
        }

        boolean[] vis = new boolean[n];

        return hasPath(adj, source, destination, vis);
    }
}