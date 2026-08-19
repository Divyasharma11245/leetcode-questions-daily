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
    private void solve(StringBuilder curr, int n){
        if(curr.length()==n*2){
            String str = curr.toString();
            if(isValid(str)){
                list.add(str);

            }
            return;
        }

        curr.append('(');
        solve(curr, n);
        curr.deleteCharAt(curr.length() - 1);

        curr.append(')');
        solve(curr, n);
        curr.deleteCharAt(curr.length() - 1);
    }
    public List<String> generateParenthesis(int n) {
        StringBuilder str = new StringBuilder();
        solve(str, n);
        return list;
    }
}