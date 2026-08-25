class Solution {
    private boolean isPalindrome(String s, int st, int end){
        while(st<=end){
            if(s.charAt(st)!=s.charAt(end)) return false;
            st++;
            end--;
        }
        return true;
    }
    private void solve(String s, int idx, List<String> list, List<List<String>> ans){
        if(idx>=s.length()){
            ans.add(new ArrayList(list));
            return;
        }

        for(int i = idx; i<s.length(); i++){
            if(isPalindrome(s, idx, i)){
                String str = s.substring(idx, i+1);
                list.add(str);
                solve(s, i+1, list, ans);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        solve(s, 0, list, ans);
        return ans;
    }
}