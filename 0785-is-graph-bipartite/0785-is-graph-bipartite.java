class Solution {
    private boolean dfs(int[][] graph, int color[], int curr, int currColor){
        color[curr] = currColor;
        for(int i = 0; i<graph[curr].length; i++){
            int neigh = graph[curr][i];
            if(color[neigh]==-1){
                color[neigh] = 1-currColor;
                if(!dfs(graph, color, neigh, color[neigh])){
                    return false;
                };
            }else if(color[neigh] == currColor) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int color[] = new int[V];
        Arrays.fill(color, -1);
        for(int i = 0; i<V; i++){
            if(color[i]==-1){
            if(!dfs(graph, color, i, 0)){
                return false;
            }
            }

        } 
        return true;
    }
}