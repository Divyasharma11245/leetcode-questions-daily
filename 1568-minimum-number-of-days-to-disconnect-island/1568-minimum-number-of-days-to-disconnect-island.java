class Solution {

    int time;
    int[] dt, low;
    boolean[] visited;
    boolean hasArticulation;
    int rows, cols;

    public int minDays(int[][] grid) {

        rows = grid.length;
        cols = grid[0].length;

        if (countIslands(grid) != 1) return 0;

        int landCount = 0;
        for (int[] row : grid)
            for (int cell : row)
                if (cell == 1) landCount++;

        if (landCount <= 2) return landCount;

        int total = rows * cols;
        dt = new int[total];
        low = new int[total];
        visited = new boolean[total];
        time = 0;
        hasArticulation = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, -1);
                    break;
                }
            }
        }

        return hasArticulation ? 1 : 2;
    }

    private void dfs(int[][] grid, int r, int c, int parent) {

        int id = r * cols + c;
        visited[id] = true;
        dt[id] = low[id] = ++time;

        int children = 0;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nc < 0 || nr >= rows || nc >= cols)
                continue;
            if (grid[nr][nc] == 0)
                continue;

            int nid = nr * cols + nc;

            if (!visited[nid]) {

                children++;
                dfs(grid, nr, nc, id);

                low[id] = Math.min(low[id], low[nid]);

                if (parent != -1 && dt[id] <= low[nid]) {
                    hasArticulation = true;
                }

            } else if (nid != parent) {
                low[id] = Math.min(low[id], dt[nid]);
            }
        }

        if (parent == -1 && children > 1) {
            hasArticulation = true;
        }
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
}
