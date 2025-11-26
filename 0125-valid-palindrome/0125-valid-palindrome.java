class Solution {
    public boolean isPalindrome(String s) {
         String st = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        
        int i = 0; 
        int j = st.length()-1;

        while(i<j){
            if(st.charAt(i)!=st.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}