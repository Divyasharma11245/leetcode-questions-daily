class Solution {
    private void dfs(int[][] isConnected, boolean visited[], int node){
        visited[node] = true;
        for(int i = 0; i<isConnected[node].length; i++){
            int curr = isConnected[node][i];
            if(isConnected[node][i] == 1 &&!visited[i]){
                dfs(isConnected, visited, i);
            }
        }
    }
    private void bfs(int[][] isConnected, boolean visited[], int node){
        Queue<Integer>q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i = 0; i<isConnected[curr].length; i++){
                if(isConnected[curr][i]==1&&!visited[i]){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = 0;
        boolean visited[] = new boolean[n];
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                bfs(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;
    }
}