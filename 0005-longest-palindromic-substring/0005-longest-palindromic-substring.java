class Solution {
    private boolean isPalindrome(int i, int j, String s){
        if(i>=j){
            return true;
        }
        if(s.charAt(i)==s.charAt(j)) {
            return isPalindrome(i+1, j-1, s);}
        return false;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLength = -1;
        int st = -1;
        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                if(isPalindrome(i, j, s)){
                   if(j - i + 1 > maxLength){
                    maxLength = j - i + 1;
                    st = i;
                    }
                }
            }
        }
        return s.substring(st, st+maxLength);
    }
}