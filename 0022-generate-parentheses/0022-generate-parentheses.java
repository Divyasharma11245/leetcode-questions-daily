class Solution {
    List<String> list = new ArrayList<>();
    private boolean isValid(String str){
        int count = 0;
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i)=='(') count++;
            else if(str.charAt(i)==')') count--;
            if (count < 0)
            return false;
        }
        if(count==0) return true;
        return false;
    }
    private void solve(StringBuilder curr, int n, int open, int close){
        if(curr.length()==n*2){
            String str = curr.toString();
                list.add(str);
            return;
        }

        if(open<n){
        curr.append('(');
        solve(curr, n,open+1, close);
        curr.deleteCharAt(curr.length() - 1);
        }

        if(close<open){
        curr.append(')');
        solve(curr, n, open, close+1);
        curr.deleteCharAt(curr.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        StringBuilder str = new StringBuilder();
        int open = 0;
        int close = 0;
        solve(str, n, open, close);
        return list;
    }
}