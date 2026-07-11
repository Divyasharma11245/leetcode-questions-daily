class Solution {
    private boolean isAlphaNum(char ch){
        if(ch>='a'&&ch<='z'||ch>='0'&&ch<='9'||ch>='A'&&ch<='Z') return true;
        return false;
    }
    public boolean isPalindrome(String s) {
        int n = s.length();
        int st = 0;
        int end = n-1;
        while(st<end){
            if(!isAlphaNum(s.charAt(st))){
                 st++;
                 continue;
            }
            if(!isAlphaNum(s.charAt(end))){
                 end--;
                 continue;
            }
            if(Character.toLowerCase(s.charAt(st))!=Character.toLowerCase(s.charAt(end))) return false;
            st++;
            end--;
        }
        return true;
    }
}