class Solution {
    private int bfs(int[][] grid, int i, int j){
        Queue<int[]> q = new LinkedList<>();
        int node = 1;
        q.offer(new int[]{i, j});
        grid[i][j] = 2;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currI = curr[0];
            int currJ = curr[1];
            int dir[][] = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for(int im = 0; im<dir.length; im++){
                int x = currI+dir[im][0];
                int y = currJ+dir[im][1];
                if(x>=0&&y>=0&&x<grid.length&&y<grid[0].length&&grid[x][y]==1){
                    q.offer(new int[]{x, y});
                    grid[x][y] = 2;
                    node++;
                }
            }
            
        }
        return node;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    int area = bfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
}