class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean vis[] = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[0], b[0]));
        int sum = 0;
        pq.offer(new int[]{0, 0});
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int currWt = curr[0];
            int currNode = curr[1];
            if(vis[currNode])  continue;
            vis[currNode] = true;
            sum+=currWt;
            for(int i = 0; i<points.length; i++){
                int x0 = points[currNode][0];
                int y0 = points[currNode][1];
                int x1 = points[i][0];
                int y1 = points[i][1];
                int neighWt = Math.abs(x1-x0)+Math.abs(y1-y0);
                if(!vis[i]){
                    pq.offer(new int[]{neighWt, i});
                }
            }
        }
        return sum;
    }
}