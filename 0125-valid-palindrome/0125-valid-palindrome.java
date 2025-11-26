class Solution {
    public boolean isPalindrome(String s) {
         String st = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        
        int n = st.length();
        for(int i = 0; i<n/2; i++){
            if(st.charAt(i)!=st.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
}