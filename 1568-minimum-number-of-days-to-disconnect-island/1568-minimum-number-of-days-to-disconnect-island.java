class Solution {

    int time;
    int[][] disc, low;
    boolean[][] visited;
    boolean hasArticulation;
    int rows, cols;

    public int minDays(int[][] grid) {

        rows = grid.length;
        cols = grid[0].length;

        if (countIslands(grid) != 1) return 0;

        int landCells = 0;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j]==1){
                    landCells++;
                }
            }
        }

        if (landCells == 1) return 1;

        disc = new int[rows][cols];
        low = new int[rows][cols];
        visited = new boolean[rows][cols];
        time = 0;
        hasArticulation = false;

        outer:
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                tarjan(i, j, -1, -1, grid);
                break outer;
        }
    }
}
    if (hasArticulation) return 1;
    return 2;
    }

    private int countIslands(int[][] grid) {
        boolean[][] vis = new boolean[rows][cols];
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                    dfsCount(grid, i, j, vis);
                }
            }
        }

        return count;
    }

    private void dfsCount(int[][] grid, int r, int c, boolean[][] vis) {

        if (r < 0 || c < 0 || r >= rows || c >= cols
            || grid[r][c] == 0 || vis[r][c])
            return;

        vis[r][c] = true;

        dfsCount(grid, r+1, c, vis);
        dfsCount(grid, r-1, c, vis);
        dfsCount(grid, r, c+1, vis);
        dfsCount(grid, r, c-1, vis);
    }

    private void tarjan(int r, int c, int pr, int pc, int[][] grid){
        visited[r][c] = true;
        disc[r][c]=low[r][c] = ++time;
        int children = 0;
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] dir: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nc < 0 || nr >= rows || nc >= cols)
                continue;

                if (grid[nr][nc] == 0)
                continue;

                if (!visited[nr][nc]) {
                    children++;
                    tarjan(nr, nc, r, c, grid);
                    low[r][c] = Math.min(low[r][c], low[nr][nc]);
                    if (pr != -1 && low[nr][nc] >= disc[r][c])
                        hasArticulation = true;
                }
                else if (nr != pr || nc != pc) {
                    low[r][c] = Math.min(low[r][c], disc[nr][nc]);
                }
        }
        if (pr == -1 && children > 1)
        hasArticulation = true;
}
}
