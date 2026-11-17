class Solution {
    private boolean dfs(int[][] graph, int node, boolean[] vis, boolean[] pathVis){
        vis[node] = true;
        pathVis[node] = true;
        for(int i = 0; i<graph[node].length; i++){
            int neigh = graph[node][i]; 
            if(!vis[neigh]){
                if(dfs(graph, neigh, vis, pathVis)){
                    return true;
                }
            }else if(pathVis[neigh]){
                return true;
            }
        }
        pathVis[node] =false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        // ArrayList<ArrayList<Integer> list = new ArrayList<>();
        // for(int i = 0; i<v; i++){
        //     list.add(new ArrayList<>());
        // }
        // for(int[] curr: graph){
        //     int u = curr[0];
        //     int v = curr[1];

        // }
        boolean vis[] = new boolean[v];
        boolean pathVis[] = new boolean[v];
        for(int i = 0; i<v; i++){
            if(!vis[i]){
                dfs(graph, i, vis, pathVis);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<v; i++){
            if(!pathVis[i]){
                list.add(i);
            }
        }
        return list;
    }
}