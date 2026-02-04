class Solution {
     private boolean dfsUtil(ArrayList<Integer> graph[], boolean vis[], boolean pathVis[], Stack<Integer> s, int curr){
        vis[curr]  = true;
        pathVis[curr] = true;
        
        for(int i = 0; i<graph[curr].size(); i++){
            int neigh = graph[curr].get(i);
            if(!vis[neigh]){
                if(dfsUtil(graph, vis, pathVis, s, neigh)){
                    return true;
                }
            }else if (pathVis[neigh]) {
                return true;
            }
        }
       pathVis[curr] = false;
        s.push(curr);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        ArrayList<Integer> graph[] = new ArrayList[V];
        
        for(int i = 0; i<V; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int edge[]: prerequisites){
            int u = edge[0];
            int v = edge[1];
            
            graph[v].add(u);
        }

        boolean vis[] = new boolean[V];
        boolean[] pathVis = new boolean[V];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i<graph.length; i++){
            if(!vis[i]){
                 if (dfsUtil(graph, vis, pathVis, s, i)) {
                    return new int[0]; 
                }
            }
        }
        
        int ans[] = new int[V];
       int idx = 0;
        while (!s.isEmpty()) {
            ans[idx++] = s.pop();
        }
        
        return ans;
    }
}