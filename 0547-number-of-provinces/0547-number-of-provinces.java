class Solution {

    int find(int x, int[] par) {
        if (par[x] != x) {
            par[x] = find(par[x], par);
        }
        return par[x];
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        int[] par = new int[n];

        for (int i = 0; i < n; i++) {
            par[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    int p1 = find(i, par);
                    int p2 = find(j, par);
                    if (p1 != p2) {
                        par[p1] = p2;
                    }
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(i, par));
        }

        return set.size();
    }
}
