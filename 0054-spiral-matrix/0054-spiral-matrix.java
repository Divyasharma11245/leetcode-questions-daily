class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int sr = 0;
        int sc = 0;
        int ec = matrix[0].length-1;
        int er = matrix.length-1;
        ArrayList<Integer> list = new ArrayList<>();
        while(sr<=er&&sc<=ec){
            for(int j = sc; j<=ec; j++){
                list.add(matrix[sr][j]);
            }
            for(int j = sr+1; j<=er; j++){
                list.add(matrix[j][ec]);
            }
            for(int j = ec-1; j>=sc; j--){
                if(sr==er){
                    break;
                }
                list.add(matrix[er][j]);
            }
            for(int j = er-1; j>=sr+1; j--){
                if(sc==ec){
                    break;
                }
                list.add(matrix[j][sc]);
            }
            sr++;
            er--;
            sc++;
            ec--;
        }
        return list;
    }
}