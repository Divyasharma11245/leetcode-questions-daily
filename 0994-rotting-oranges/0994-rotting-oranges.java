class Solution {
    class Info{
        int i;
        int j;
        int time;
        Info(int i, int j, int t){
            this.i = i;
            this.j = j;
            this.time = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Info> q = new LinkedList<>();
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]==2){
                    q.add(new Info(i, j, 0));
                }
            }
        }
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int maxTime = 0;
        while(!q.isEmpty()){
            Info curr = q.remove();
            int i = curr.i;
            int j = curr.j;
            int time = curr.time;
            maxTime = Math.max(time, maxTime);
            if(i+1<grid.length&&grid[i+1][j]==1&&!vis[i+1][j]){
                vis[i+1][j] = true;
                grid[i+1][j] = 2;
                q.add(new Info(i+1, j, time+1));
            }
            if(j+1<grid[0].length&&grid[i][j+1]==1&&!vis[i][j+1]){
                vis[i][j+1] = true;
                grid[i][j+1] = 2;
                q.add(new Info(i, j+1, time+1));
            }
            if(i-1>=0&&grid[i-1][j]==1&&!vis[i-1][j]){
                vis[i-1][j] = true;
                grid[i-1][j] = 2;
                q.add(new Info(i-1, j, time+1));
            }
            if(j-1>=0&&grid[i][j-1]==1&&!vis[i][j-1]){
                vis[i][j-1] = true;
                grid[i][j-1] = 2;
                q.add(new Info(i, j-1, time+1));
            }
        }
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return maxTime;
    }
}