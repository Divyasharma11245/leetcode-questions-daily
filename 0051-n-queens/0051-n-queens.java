class Solution {
    private boolean isSafe(List<String> list, int row, int col, int n){

        for(int j = 0; j<row; j++){
            if(list.get(j).charAt(col)=='Q') return false;
        }

        for(int i=row-1,j=col-1; i>=0&& j>=0; i--, j--){
            if(list.get(i).charAt(j)=='Q') return false;
        }

        for(int i =row-1, j=col+1; i>=0&& j<n; i--, j++){
            if(list.get(i).charAt(j)=='Q') return false;
        }

        return true;
    }
    private void solve(List<List<String>> ans, List<String> list, int n, int row){
        if(row>=n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int j = 0; j<n; j++){
            if(isSafe(list, row, j, n)){
                StringBuilder sb = new StringBuilder(list.get(row));
                sb.setCharAt(j, 'Q');
                list.set(row, sb.toString());

                // Move to next row
                solve(ans, list, n, row + 1);

                // Backtrack
                sb.setCharAt(j, '.');
                list.set(row, sb.toString());
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        StringBuilder emptyRow = new StringBuilder();

        for (int i = 0; i < n; i++) {
            emptyRow.append('.');
        }

        for (int i = 0; i < n; i++) {
            list.add(emptyRow.toString());
        }
        solve(ans, list, n, 0);
        return ans;
    }
}