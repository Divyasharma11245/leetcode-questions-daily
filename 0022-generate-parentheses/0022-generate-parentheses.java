class Solution {
    private void generate(int n, List<String> list, int open, int close, String curr){
        if(curr.length()==2*n){
            list.add(curr);
            return;
        }
        if(open<n){
            generate(n, list, open+1, close, curr+'(');
        }
        if(close<open){
            generate(n, list, open, close+1, curr+')');
        }
    }
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        String curr = "";
        generate(n, list, 0, 0, curr);
        return list;
    }
}