class Solution {
    private void solve(int k, int n, int i, List<Integer> list, List<List<Integer>> ans){
        if(k==0&&n==0) {
            if(!ans.contains(new ArrayList<>(list))){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if(k<=0){
            return;
        }
        if(n<=0||i>9){
            return;
        }
        list.add(i);
        solve(k-1, n-i, i+1, list, ans);
        list.remove(list.size()-1);
        solve(k, n, i+1, list, ans);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(k, n, 1, list, ans);
        return ans;
    }
}