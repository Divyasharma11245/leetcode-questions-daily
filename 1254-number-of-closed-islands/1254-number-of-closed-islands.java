class Solution {
    int n, m;
        private void dfs(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 1)
            return;
        
        grid[i][j] = 1;  // mark visited
        
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
    public int closedIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        
        for(int i = 0; i < n; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, m - 1);
        }
        
        for(int j = 0; j < m; j++) {
            dfs(grid, 0, j);
            dfs(grid, n - 1, j);
        }

        int count = 0;
        for(int i = 1; i < n - 1; i++) {
            for(int j = 1; j < m - 1; j++) {
                if(grid[i][j] == 0) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
}
