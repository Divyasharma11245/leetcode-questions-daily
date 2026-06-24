class Solution {
    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int u, int v, boolean vis[]){
        vis[u] = true;
        if(u==v) return true;

        for(int neigh:adj.get(u)){
            if(!vis[neigh]){
                 if(dfs(adj, neigh, v, vis)) return true;
            }
        }
        return false;

    }
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<=edges.length; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            boolean[] vis = new boolean[edges.length + 1];

            if(!adj.get(u).isEmpty()
               && !adj.get(v).isEmpty()
               && dfs(adj, u, v, vis)) {

                return edge;
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[]{};
    }
}