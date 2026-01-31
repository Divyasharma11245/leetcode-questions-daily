class Solution {
    private void dfsUtil(ArrayList<Integer>[]graph, boolean vis[], int start, int info[]){
        vis[start] = true;
         info[0]++;  
         info[1] += graph[start].size();

        for(int i = 0; i<graph[start].size(); i++){
            int neigh = graph[start].get(i);
            if(!vis[neigh]){
                dfsUtil(graph, vis, neigh, info);
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[]edge: edges){
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        boolean vis[] = new boolean[n];
        int count= 0 ;


        for(int i = 0; i<graph.length; i++){
            if(!vis[i]){
            int info[] = new int[2];
            dfsUtil(graph, vis, i, info);
            int nodes = info[0];
            int ed = info[1] / 2; 

                if (ed == nodes * (nodes - 1) / 2) {
                    count++;
            }
        }
        
    }
    return count;
}
}