class Solution {
    private boolean solve(String s, int idx, List<String> wordDict, Boolean dp[]){
        if(idx>=s.length()){
            return true;
        }
        if(dp[idx]!=null) return dp[idx];
        if(wordDict.contains(s.substring(idx))) return true;
        for(int i = idx; i<s.length(); i++){
            String str = s.substring(idx, i+1);
            if(wordDict.contains(str)&&solve(s, i+1, wordDict, dp)) return dp[idx] = true;
        }
        return dp[idx] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        StringBuilder temp = new StringBuilder();
        Boolean dp[] = new Boolean[s.length()+1];
        return solve(s, 0, wordDict, dp);
    }
}