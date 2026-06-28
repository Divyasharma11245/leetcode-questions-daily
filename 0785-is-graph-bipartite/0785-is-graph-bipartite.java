class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        int col[] = new int[graph.length];
        Arrays.fill(col, -1);
        for(int i = 0; i<graph.length; i++){
            if(col[i]==-1){
            q.add(i);
            col[i] = 0;
            }

            while(!q.isEmpty()){
                int curr = q.remove();
                for(int j = 0; j<graph[curr].length; j++){
                    int neigh = graph[curr][j]; 
                    if(col[neigh]==-1){
                        col[neigh] = col[curr]==0?1:0;
                        q.add(neigh);
                    }else if(col[neigh]==col[curr]) return false;
                }
            }
        }
        return true;
    }
}