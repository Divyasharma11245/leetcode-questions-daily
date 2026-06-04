class Solution {
    class Pair{
        int i;
        int j;
        int time;
        Pair(int i, int j, int time){
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n =grid[0].length;
        boolean vis[][] = new boolean[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j, 0));
                }
            }
        }
        int maxTime = 0;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int i = curr.i;
            int j = curr.j; 
            int time = curr.time;
            maxTime = Math.max(maxTime, time);
            
            if(i-1>=0&&!vis[i-1][j]&&grid[i-1][j]==1){
                vis[i-1][j] = true;
                grid[i-1][j] = 2;
                q.add(new Pair(i-1,j,time+1));
            }
            if(i+1<m&&!vis[i+1][j]&&grid[i+1][j]==1){
                vis[i+1][j] = true;
                grid[i+1][j] = 2;
                q.add(new Pair(i+1,j,time+1));
            }
            if(j-1>=0&&!vis[i][j-1]&&grid[i][j-1]==1){
                vis[i][j-1] = true;
                grid[i][j-1] = 2;
                q.add(new Pair(i, j-1, time+1));
            }
            if(j+1<n&&!vis[i][j+1]&&grid[i][j+1]==1){
                vis[i][j+1] = true;
                grid[i][j+1] = 2;
                q.add(new Pair(i, j+1, time+1));
            }
        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return maxTime;
    }
}