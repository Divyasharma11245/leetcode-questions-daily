class Solution {
    int n;
    int m;
    char[][] board;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private boolean find(int i, int j, int idx, String word){
        if(idx==word.length()){
            return true;
        }
        if (i < 0 || j < 0 || i >= n || j >= m || board[i][j] == '$' || board[i][j] != word.charAt(idx)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '$';
        for(int dir[] : directions){
            int new_i = i+dir[0];
            int new_j = j+dir[1];
            if(find(new_i, new_j, idx+1, word)) return true;
        }
        board[i][j] = temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        this.board = board;
        n = board.length;
        m = board[0].length;
        for(int i = 0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]==word.charAt(0)&&find(i, j, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }
}