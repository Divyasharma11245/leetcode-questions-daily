class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                map.put(grid[i][j], map.getOrDefault(grid[i][j],0)+1);
            }
        }
        int n = grid.length;
        int a = -1;
        int b = -1;
       for(int i = 1; i <= n*n; i++){
            int freq = map.getOrDefault(i, 0);
            
            if(freq == 2) a = i;
            if(freq == 0) b = i;
        }

        return new int[]{a, b};

    }
}