class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        String str = s+s;
        int m = str.length();
        int n = goal.length();
        for(int i = 0; i<=m-n; i++){
            boolean isMatch = true;
            for(int j=0; j<n; j++){
                if(str.charAt(i+j)!=goal.charAt(j)){
                    isMatch = false;
                    break;
                }
            }
            if(isMatch) return true;
        }
        return false;
    }
}