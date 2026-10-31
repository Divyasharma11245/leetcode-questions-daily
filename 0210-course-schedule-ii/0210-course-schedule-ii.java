class Solution {
    private boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean pathVis[], int curr, Stack<Integer> st){
        vis[curr] = true;
        pathVis[curr] = true;
        for(int i = 0; i<adj.get(curr).size(); i++){
            int neigh = adj.get(curr).get(i);
            if(!vis[neigh]){
                if(dfs(adj, vis, pathVis, neigh, st)){
                    return true;
                }
            }else if(pathVis[neigh]) return true;
        }
        pathVis[curr] = false;
        st.push(curr);
        return false;
    }
    public int[] findOrder(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        } 
        for(int[] num:prerequisites){
            int u = num[0];
            int v = num[1];
            adj.get(v).add(u);
        }
        boolean vis[] = new boolean[n];
        boolean pathVis[] = new boolean[n];
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        for(int i =0; i<n; i++){
            if(!vis[i]){
                if(dfs(adj, vis, pathVis, i, st)) return new int[]{};
            }
        }
        int i = 0;
        while(!st.isEmpty()){
            ans[i++] = st.pop();
        }
        return ans;
    }
}