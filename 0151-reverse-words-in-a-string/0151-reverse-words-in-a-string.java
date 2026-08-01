class Solution {
    private String reverse(String s){
        String ans = "";
        for(int i = s.length()-1; i>=0; i--){
            ans+=s.charAt(i);
        }
        return ans;
    }
    public String reverseWords(String s) {
        s = reverse(s);
        String ans = "";
        int n = s.length();
        for(int i = 0; i<s.length(); i++){
             while(i < n && s.charAt(i) == ' ')
                i++;
            String word = "";
            while(i<n&&s.charAt(i)!=' '){
                word+=s.charAt(i);
                i++;
            }

            word  = reverse(word);
            if(word.length()>0) ans+=word+ " ";
        }
        return ans.trim();
    }
}