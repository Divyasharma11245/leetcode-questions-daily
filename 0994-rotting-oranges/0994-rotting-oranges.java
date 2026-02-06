class Solution {
    class Pair{
        int i;
        int j;
        int time;
        Pair(int i, int j, int t){
            this.i = i;
            this.j = j;
            this.time = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue <Pair> q = new LinkedList<>();
        boolean vis[][] = new boolean[m][n];

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        int ans = 0;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int i = curr.i;
            int j = curr.j;
            int time = curr.time;

            ans = Math.max(ans, time);

            if(i-1>=0&&!vis[i-1][j]&&grid[i-1][j]==1){
                vis[i-1][j] = true;
                q.add(new Pair(i-1, j, time+1));
            }

            if(j+1<n&&!vis[i][j+1]&&grid[i][j+1]==1){
                vis[i][j+1] = true;
                q.add(new Pair(i, j+1, time+1));
            }

            if(i+1<m&&!vis[i+1][j]&&grid[i+1][j]==1){
                vis[i+1][j] = true;
                q.add(new Pair(i+1, j, time+1));
            }

            if(j-1>=0&&!vis[i][j-1]&&grid[i][j-1]==1){
                vis[i][j-1] = true;
                q.add(new Pair(i, j-1, time+1));
            }
        }

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j]==1&&!vis[i][j]){
                    return -1;
                }
            }
        }
        return ans;
    }
}