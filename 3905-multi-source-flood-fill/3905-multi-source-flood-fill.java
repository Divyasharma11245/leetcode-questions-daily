class Solution {
    class Pair{
        int i;
        int j;
        int color;
        int time;
        Pair(int i, int j, int color, int time){
            this.i = i;
            this.j = j;
            this.color = color;
            this.time = time;
        }
    }
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int grid[][] = new int[n][m];
        int[][] time = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            Arrays.fill(time[i], -1);
        }
        for(int i =0; i<sources.length; i++){
            int r = sources[i][0];
            int c = sources[i][1];
            int color = sources[i][2];
            grid[r][c] = color;
            time[r][c] = 0;
            q.add(new Pair(r, c, color, 0));
        }

        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, -1, 0, 1};
        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int k = 0; k < 4; k++){
                int ni = curr.i + dr[k];
                int nj = curr.j + dc[k];
                if(ni >= 0 && nj >= 0 && ni < n && nj < m){
                    if(time[ni][nj] == -1){
                        grid[ni][nj] = curr.color;
                        time[ni][nj] = curr.time + 1;
                        q.add(new Pair(ni, nj, curr.color, curr.time + 1));
                }
                else if(time[ni][nj] == curr.time + 1){
                         if(curr.color > grid[ni][nj]){
                            grid[ni][nj] = curr.color;
                            q.add(new Pair(ni, nj, grid[ni][nj], curr.time + 1));
                        }
                    }
                }
            }
            
        }
        return grid;
    }
}