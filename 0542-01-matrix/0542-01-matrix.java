class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(mat[i][j]==0) q.add(new int[]{i, j});
                if(mat[i][j]==1) mat[i][j] = -1;
            }
        }
        int dir[][] = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while(!q.isEmpty()){
                int curr[] = q.poll();
                int currI = curr[0];
                int currJ = curr[1];
                for(int i = 0; i<dir.length; i++){
                    int x = currI+dir[i][0];
                    int y = currJ+dir[i][1];
                    if(x<0||y<0||x>=m||y>=n){
                        continue;
                    }
                    if(mat[x][y]==-1){
                    mat[x][y] = mat[currI][currJ]+1;
                    q.add(new int[]{x, y});
                    }
                    
                }
            }
            return mat;
        }
    }
