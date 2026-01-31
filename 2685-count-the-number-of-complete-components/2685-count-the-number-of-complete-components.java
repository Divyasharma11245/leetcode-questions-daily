class Solution {
    private int[] bfsUtil(ArrayList<Integer> []graph, boolean vis[], int start){
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        vis[start] = true;

        int nodes = 0;
        int edges = 0;
        while(!q.isEmpty()){
            int curr = q.remove();
            nodes++;

            edges += graph[curr].size();
             for (int neigh : graph[curr]) {
            if (!vis[neigh]) {
                vis[neigh] = true;
                q.add(neigh);
            }
        }
        }
        return new int[]{nodes, edges / 2};
    
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
                int[] res = bfsUtil(graph, vis, i);
                int nodes = res[0];
                int ed = res[1];

                
                if (ed == nodes * (nodes - 1) / 2) {
                    count++;
                }
            }
        }
        return count;
    }
}