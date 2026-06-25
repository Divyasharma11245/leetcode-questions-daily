class Solution {
     private boolean isCycle(ArrayList<ArrayList<Integer>> adj, int curr, boolean[] vis, boolean[] st){
        vis[curr] = true;
        st[curr] = true;
        for(int neigh: adj.get(curr)){
            if(!vis[neigh]){
                 if(isCycle(adj, neigh, vis, st)) return true;
            }else if(st[neigh]) return true;
        }
        st[curr] = false;
        return false;
    }

    private void topSort(ArrayList<ArrayList<Integer>> adj, int curr, boolean[] vis, Stack<Integer> st){
        vis[curr] = true;
        for(int neigh: adj.get(curr)){
            if(!vis[neigh]){
                topSort(adj, neigh, vis, st);
            }
        }
        st.push(curr);
    }
    public int[] findOrder(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[]: edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
        }

        boolean vis[] = new boolean[V];
        boolean st[] = new boolean[V];
        for(int i = 0; i<V; i++){
            if(!vis[i]){
                if(isCycle(adj, i, vis, st)) return new int[]{};
            }
        }

        vis = new boolean[V];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i<V; i++){
            if(!vis[i]){
                topSort(adj, i, vis, s);
            }
        }

        int[] ans = new int[V];
        int i = 0;
        while(!s.isEmpty()){
            ans[i] = s.pop();
            i++;
        }
        return ans;
    }
}