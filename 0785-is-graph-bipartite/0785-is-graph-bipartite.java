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
    private boolean bfs(int graph[][], int color[], int curr, int currColor){
        Queue<int[]> q = new LinkedList<>();
        color[curr] = currColor;
        q.add(new int[]{curr, currColor});
        while(!q.isEmpty()){
            int currArr[] = q.poll();
            int node = currArr[0];
            int clr = currArr[1];
            for(int i = 0; i<graph[node].length; i++){
                int neigh = graph[node][i];
                if(color[neigh]==-1){
                    color[neigh] = 1-clr;
                    q.add(new int[]{neigh, color[neigh]});
                }else if(color[neigh]==clr){
                    return false;
                }
            }

        }
                    return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int color[] = new int[V];
        Arrays.fill(color, -1);
        for(int i = 0; i<V; i++){
            if(color[i]==-1){
            if(!bfs(graph, color, i, 0)){
                return false;
            }
            }

        } 
        return true;
    }
}