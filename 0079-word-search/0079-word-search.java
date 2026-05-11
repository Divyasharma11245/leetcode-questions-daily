class Solution {
    private boolean find(char[][] board, int i, int j, int idx, String word){
        int m = board.length;
        int n = board[0].length;
        if(idx==word.length()){
            return true;
        }
        if(i<0||j<0||i>=m||j>=n||board[i][j]!=word.charAt(idx)||board[i][j]=='$'){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '$';
        int dir[][] = {{0,1}, {1,0}, {-1, 0}, {0, -1}};
        for(int[] d:dir){
            int i_ = i+d[0];
            int j_ = j+d[1];
            if(find(board, i_, j_, idx+1, word)) return true;
        }
        board[i][j] = temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i =0; i<m; i++){
            for(int j = 0; j<n; j++){
                if((board[i][j] == word.charAt(0)&&find(board, i, j, 0, word))) return true;
            }
        }
        return false;
    }
}