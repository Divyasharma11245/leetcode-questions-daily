class Solution {
    private void dfs(int i, int j, boolean vis[][], char grid[][], int m, int n){
        if(i<0||j<0||i>=m||j>=n||vis[i][j]||grid[i][j]!='1') return;
        vis[i][j] = true;
        dfs(i+1, j, vis, grid, m, n);
        dfs(i, j+1, vis, grid, m, n);
        dfs(i-1, j, vis, grid, m, n);
        dfs(i, j-1, vis, grid, m, n);

    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];

        int islands = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j]=='1'&&!vis[i][j]){
                    dfs(i, j, vis, grid, m, n);
                    islands++;
                }
            }
        }
        return islands;
    }
}