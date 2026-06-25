class Solution{
    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int curr, boolean[] vis, boolean[] st){
        vis[curr] = true;
        st[curr] = true;
        for(int neigh: adj.get(curr)){
            if(!vis[neigh]){
                 if(dfs(adj, neigh, vis, st)) return true;
            }else if(st[neigh]) return true;
        }
        st[curr] = false;
        return false;
    }
    public boolean canFinish(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[]: edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

        boolean vis[] = new boolean[n];
        boolean st[] = new boolean[n];
        for(int i = 0; i<n; i++){
            if(!vis[i]){
                if(dfs(adj, i, vis, st)) return false;
            }
        }
        return true;
    }
}