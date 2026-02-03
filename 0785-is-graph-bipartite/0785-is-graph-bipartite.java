class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;

        ArrayList<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
            for (int neigh : graph[i]) {
                adj[i].add(neigh);
            }
        }

        int color[] = new int[V];
        for(int i = 0; i<color.length; i++){
            color[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i<adj.length; i++){
            if(color[i]==-1){
                color[i] = 0;
                q.add(i);
            }

            while(!q.isEmpty()){
                int curr = q.remove();
                for(int j = 0; j<adj[curr].size(); j++){
                    int neigh = adj[curr].get(j);
                    if(color[neigh]==-1){
                        int nextCol = color[curr]==0?1:0;
                        color[neigh] = nextCol;
                        q.add(neigh);
                    }else if(color[neigh]==color[curr]){
                        return false;
                    }
                }
            }   
        }
        return true;
    }
}