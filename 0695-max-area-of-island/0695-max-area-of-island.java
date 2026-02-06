class Solution {
    private int dfsUtil(int[][] grid, int i, int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length){
            return 0;
        }
        if(grid[i][j]==0){
            return 0;
        }
        grid[i][j] = 0;

        int area = 1;

        area += dfsUtil(grid, i-1, j);
        area += dfsUtil(grid, i, j+1);
        area += dfsUtil(grid, i+1, j);
        area += dfsUtil(grid, i, j-1);

        return area;

    }
    public int maxAreaOfIsland(int[][] grid) {
        int n= grid.length;
        int m = grid[0].length;
        int max = 0;
        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j]==1){
                    count = dfsUtil(grid, i, j);
                    max = Math.max(count, max);
                }
            }
        }
        return max;
    }
}