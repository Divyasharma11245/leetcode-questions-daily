class Solution {
    private boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean pathVis[], int curr){
        vis[curr] = true;
        pathVis[curr] = true;
        for(int i =0; i<adj.get(curr).size(); i++){
            int neigh = adj.get(curr).get(i);
            if(!vis[neigh]){
                if(dfs(adj, vis, pathVis, neigh)) return true;
            }else{
                if(pathVis[neigh]) return true;
            }
        }
        pathVis[curr]= false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] curr:prerequisites){
            int u = curr[0];
            int v = curr[1];
            adj.get(v).add(u);
        }
        boolean vis[] = new boolean[n];
        boolean pathVis[] = new boolean[n];
        for(int i = 0; i<n; i++){
            if(!vis[i]){
                if(dfs(adj, vis, pathVis, i)) return false;
            }
            
        }
        return true;
    }
}