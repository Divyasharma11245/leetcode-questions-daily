class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[0]-b[0]);
        int dist[][] = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
            
        }
        dist[0][0] = 0;

        pq.add(new int[]{0, 0, 0});
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int currDist = curr[0];
            int currI = curr[1];
            int currJ = curr[2];
            if(currDist > dist[currI][currJ]) {
                continue;
            }
            if(currI == n-1 && currJ == m-1) {
                return currDist;
            }
            int dir[][] = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            for(int i = 0; i<dir.length; i++){
                int x = currI+dir[i][0];
                int y = currJ+dir[i][1];
                if(x<0||y<0||x>=n||y>=m){
                    continue;
                }
                int effort = Math.max(
                    currDist,
                    Math.abs(heights[x][y] - heights[currI][currJ])
                );
                if(dist[x][y]>effort){
                    dist[x][y] = effort;
                    pq.offer(new int[]{effort, x, y});
                }
               
            } 
        }
        return 0;

    }
}