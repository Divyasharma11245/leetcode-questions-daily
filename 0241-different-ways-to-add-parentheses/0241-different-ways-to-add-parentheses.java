class Solution {
    private List<Integer> solve(int start, int n, String expression){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =start; i<=n; i++){
            if(expression.charAt(i)=='+'||expression.charAt(i)=='-'||expression.charAt(i)=='*'){
            List<Integer> left = solve(start, i-1, expression);
            List<Integer> right = solve(i+1, n, expression);
            for(int l:left){
                for(int r:right){
                    if(expression.charAt(i)=='+'){
                        list.add(l+r);
                    }
                    else if(expression.charAt(i)=='-'){
                        list.add(l-r);
                    }
                    else{
                        list.add(l*r);
                    }
                }
            }
            }

        }
        if(list.size()==0){
            int num = Integer.parseInt(expression.substring(start, n + 1));
            list.add(num);
        }
        return list;
    }
    public List<Integer> diffWaysToCompute(String expression) {
        return solve(0, expression.length()-1, expression);
    }
}