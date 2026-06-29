class Solution {
    private void dfs(ArrayList<ArrayList<Integer>> adj, int curr, boolean[] vis) {
        vis[curr] = true;

        for (int neigh : adj.get(curr)) {
            if (!vis[neigh]) {
                dfs(adj, neigh, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        boolean[] vis = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(adj, i, vis);
                count++;
            }
        }

        return count;
    }
}