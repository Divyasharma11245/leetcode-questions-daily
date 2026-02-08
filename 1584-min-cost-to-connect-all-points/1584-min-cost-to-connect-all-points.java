class Solution {
    class Pair implements Comparable<Pair> {
        int v;
        int cost;

        Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        boolean[] vis = new boolean[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));   // start from node 0

        int totalCost = 0;
        int count = 0;

        while (count < n) {

            Pair curr = pq.poll();
            int u = curr.v;

            if (vis[u]) continue;

            vis[u] = true;
            totalCost += curr.cost;
            count++;

            for (int v = 0; v < n; v++) {
                if (!vis[v]) {
                    int cost = Math.abs(points[u][0] - points[v][0])
                             + Math.abs(points[u][1] - points[v][1]);
                    pq.add(new Pair(v, cost));
                }
            }
        }

        return totalCost;
    }
}
