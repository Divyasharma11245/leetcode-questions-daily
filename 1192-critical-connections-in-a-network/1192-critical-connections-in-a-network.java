class Solution {
    int time = 0;
    private void dfs(List<List<Integer>> graph, int curr, int dt[], int low[], int par, boolean vis[], List<List<Integer>> ans){
        vis[curr] = true;
        dt[curr]=low[curr]=++time;
        for(int i = 0; i<graph.get(curr).size(); i++){
            int neigh = graph.get(curr).get(i);
            if(par==neigh){
                continue;
            }else if(!vis[neigh]){
                dfs(graph, neigh, dt, low, curr, vis, ans);
                low[curr] = Math.min(low[curr], low[neigh]);
                if(dt[curr]<low[neigh]){
                    ans.add(Arrays.asList(curr, neigh));
                }
            }else{
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
         List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int dt[] = new int[n];
        int low[] = new int[n];
        boolean vis[] = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(!vis[i]){
               dfs(graph, i, dt, low, -1, vis, ans);
            }
        }
            return ans;
    }
}