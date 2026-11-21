class Solution {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        int INF = 100000000;
        for(int k = 0; k<n; k++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(dist[i][k]!=INF&&dist[k][j]!=INF){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
        }
          
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][] = new int[n][n];
        int INF = 100000000;
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            dist[u][v] = weight;
            dist[v][u] = weight;
        }
        int count[]= new int[n];
        floydWarshall(dist);
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(dist[i][j]>0&&dist[i][j]<=distanceThreshold){
                    count[i]++;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for(int i = n-1; i>=0; i--){
            if(count[i]<min){
                min = count[i];
                ans =  i;
            }
        }
        return ans;
    }
}