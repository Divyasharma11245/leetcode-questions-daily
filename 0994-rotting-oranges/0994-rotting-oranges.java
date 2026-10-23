class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2) q.add(new int[]{i, j});
            }
        }
        if(fresh==0) return 0;
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                int[] curr = q.poll();
                int currI = curr[0];
                int currJ = curr[1];
                int dir[][] = new int[][]{{0,1}, {0,-1}, {1, 0}, {-1, 0}};
                for(int im = 0; im<dir.length; im++){
                    int x = currI+dir[im][0];
                    int  y = currJ+dir[im][1];
                    if(x<0||y<0||x>=grid.length||y>=grid[0].length){
                        continue;
                    }
                    if(grid[x][y]==1&&!vis[x][y]){
                        q.add(new int[]{x, y});
                        vis[x][y]=true;
                        fresh--;
                        grid[x][y] = 2;
                    }

                }
                
            }

           
            count++;
        }
        if(fresh!=0) return -1;
         return count-1;
    }
}