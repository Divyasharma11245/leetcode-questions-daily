class Solution {
    private void dfs(char[][] grid, boolean visited[][], int i, int j){
        if(i < 0 || j < 0 ||i>=grid.length||j>=grid[0].length||visited[i][j]||grid[i][j]=='0'){
            return;
        }
        int dir[][] = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        visited[i][j] = true;
        for(int ik = 0; ik<dir.length; ik++){
            dfs(grid, visited, i+dir[ik][0], j+dir[ik][1]);
        }
    }
    public int numIslands(char[][] grid) {
        int islands = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
               if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    islands++;
}
            }
        }
        return islands;
    }
}