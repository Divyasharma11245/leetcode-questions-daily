class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int sRow = 0;
        int eRow = m-1;
        int sCol = 0;
        int eCol = n-1;
        ArrayList<Integer> list = new ArrayList<>();
        while(sRow<=eRow&&sCol<=eCol){
            for(int i = sCol; i<=eCol; i++){
                list.add(matrix[sRow][i]);
            }
            for(int j = sRow+1; j<=eRow; j++){
                list.add(matrix[j][eCol]);
            }
            for(int i = eCol-1; i>=sCol; i--){
                if(sRow==eRow) break;
                list.add(matrix[eRow][i]);
            }
            for(int j = eRow-1; j>sRow; j--){
                if(sCol==eCol) break;
                list.add(matrix[j][sCol]);
            }
        sRow++;
        eRow--;
        sCol++;
        eCol--;
        }
        return list;

    }
}