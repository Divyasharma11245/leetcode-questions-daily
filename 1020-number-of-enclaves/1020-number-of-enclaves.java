

class Solution {
    private int bfs(int[][] grid, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        boolean flag = true;

        q.add(new int[]{i, j});
        grid[i][j] = 2;

        if (i == 0 || j == 0 || i == grid.length - 1
                || j == grid[0].length - 1) {
            flag = false;
        }

        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currI = curr[0];
            int currJ = curr[1];

            count++;

            for (int[] d : dir) {
                int x = currI + d[0];
                int y = currJ + d[1];

                if (x >= 0 && y >= 0 && x < grid.length
                        && y < grid[0].length && grid[x][y] == 1) {

                    if (x == 0 || y == 0 || x == grid.length - 1
                            || y == grid[0].length - 1) {
                        flag = false;
                    }

                    q.add(new int[]{x, y});
                    grid[x][y] = 2;
                }
            }
        }

        return flag ? count : 0;
    }

    public int numEnclaves(int[][] grid) {
        int total = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    total += bfs(grid, i, j);
                }
            }
        }

        return total;
    }
}