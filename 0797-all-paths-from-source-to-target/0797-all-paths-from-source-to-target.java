class Solution {
    private void dfs(int[][] graph, int curr, int dest, List<Integer> path, List<List<Integer>> ans){
        path.add(curr);

        if (curr == dest) {
            ans.add(new ArrayList<>(path));
        } else {
            for (int neigh : graph[curr]) {
                dfs(graph, neigh, dest, path, ans);
            }
        }

        path.remove(path.size() - 1); 
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
       List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        int src = 0;
        int dest = graph.length - 1;

        dfs(graph, src, dest, path, ans);
        return ans;    
    }
}