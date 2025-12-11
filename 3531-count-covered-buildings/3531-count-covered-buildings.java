import java.util.*;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {

        Map<Integer, Integer> rowMin = new HashMap<>();
        Map<Integer, Integer> rowMax = new HashMap<>();
        
 
        Map<Integer, Integer> colMin = new HashMap<>();
        Map<Integer, Integer> colMax = new HashMap<>();
        

        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];
            
            rowMin.put(x, Math.min(rowMin.getOrDefault(x, y), y));
            rowMax.put(x, Math.max(rowMax.getOrDefault(x, y), y));
            
            colMin.put(y, Math.min(colMin.getOrDefault(y, x), x));
            colMax.put(y, Math.max(colMax.getOrDefault(y, x), x));
        }
        
        int count = 0;
        
        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];
            
            if (y > rowMin.get(x) && y < rowMax.get(x) &&
                x > colMin.get(y) && x < colMax.get(y)) {
                count++;
            }
        }
        
        return count;
    }
}
