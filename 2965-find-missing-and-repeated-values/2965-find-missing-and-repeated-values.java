class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<n; i++){
            for(int j =0;j<m;j++){
                map.put(grid[i][j], map.getOrDefault(grid[i][j], 0)+1);
            }
        }

        int twice = -1;
        int missing = -1;
        for(int i =1; i<=n*n; i++){
            int freq = map.getOrDefault(i, 0);
            if(freq==0) missing = i;
            if(freq==2) twice = i;
        }
        return new int[]{twice, missing};
    }
}