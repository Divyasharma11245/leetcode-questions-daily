class Solution {
    int[][] directions = {{0,1}, {0,-1},{1,0},{-1,0}};
    private boolean find(char[][] board, String word, int i, int j, int idx){
        if(idx>=word.length()) return true;
        if(i>=board.length||j>=board[0].length||i<0||j<0||board[i][j]=='$'||board[i][j]!=word.charAt(idx)) return false;

        char temp = board[i][j];
        board[i][j] = '$';
        for(int[] dir: directions){
            int new_i = i+dir[0];
            int new_j = j+dir[1];
            if(find(board, word, new_i, new_j, idx+1)) return true;
            
        }
        board[i][j] = temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j]==word.charAt(0)&&find(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
}