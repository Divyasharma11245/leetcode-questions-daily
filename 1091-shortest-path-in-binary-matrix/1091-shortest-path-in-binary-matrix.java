class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1||grid[n-1][n-1]==1) return -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        grid[0][0] = -1;
        int dir[][] = new int[][]{{-1, -1}, {1, -1}, {-1, 1}, {1,1}, {-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currI = curr[0];
            int currJ = curr[1];
            int currCount = curr[2];
            if(currI == n-1&&currJ == n-1) return currCount;
            for(int i = 0; i<dir.length; i++){
                int x = currI+dir[i][0];
                int y = currJ+dir[i][1];
                if(x<0||y<0||x>=n||y>=n||grid[x][y]==1||grid[x][y]==-1) continue;
                q.add(new int[]{x, y, currCount+1});
                grid[x][y] = -1;
            }
        }
        return -1;
    }
}