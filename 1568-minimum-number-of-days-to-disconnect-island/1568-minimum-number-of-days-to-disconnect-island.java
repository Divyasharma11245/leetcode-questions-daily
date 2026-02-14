class Solution {
    private void dfsUtil(int grid[][],int n, int m, int i, int j, boolean vis[][]){
       if (i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || grid[i][j] == 0) {
            return;
        }
        vis[i][j] = true;
        dfsUtil(grid, n, m, i+1, j, vis);
        dfsUtil(grid, n, m, i, j+1, vis);
        dfsUtil(grid, n, m, i-1, j, vis);
        dfsUtil(grid, n, m, i, j-1, vis);

    }
    private int noOfIslands(int[][]grid, int n, int m){
        int islands = 0;
        boolean vis[][] = new boolean[n][m];

        for(int i =0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j]==1 &&!vis[i][j]){
                    dfsUtil(grid,n, m, i, j, vis);
                    islands++;
                }
            }
        }
        return islands;
    }
    public int minDays(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int islands = noOfIslands(grid, n, m);

        if(islands==0||islands>1){
            return 0;
        }else{
            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    if(grid[i][j]==1){
                        grid[i][j] = 0;
                        islands = noOfIslands(grid, n, m);
                        if(islands>1||islands==0){
                            return 1;
                        }
                        grid[i][j]=1;
                    }
                    }
                }
            }
        return 2;
    }
}