class Solution {
    private boolean cycleDFS(int src, boolean vis[], boolean recPath[], int[][] prerequisites){
        vis[src] = true;
        recPath[src] = true;

        for(int i = 0; i<prerequisites.length; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            if(u==src){
                if(!vis[v]){
                    if(cycleDFS(v, vis, recPath, prerequisites)) return true;
                }else if(recPath[v])  return true;
            }
        }
        recPath[src] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean vis[] = new boolean[numCourses];
        boolean recPath[] = new boolean[numCourses];

        for(int i = 0; i<numCourses; i++){
            if(!vis[i]){
                if(cycleDFS(i, vis, recPath, prerequisites))  return false;
            }
        }
        return true;
    }
}