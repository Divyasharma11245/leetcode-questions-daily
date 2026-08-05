class Solution {
    private String reverse(String str){
        String ans = "";
        for(int i = str.length()-1; i>=0; i--){
            ans+=str.charAt(i);
        }
        return ans;
    }
    public String reverseWords(String s) {
        s = reverse(s);
        String newString = "";
       int i = 0;

        while(i < s.length()){
            while(i < s.length()&&s.charAt(i)==' '){
                i++;
            }
            String word = "";
            while(i < s.length()&&s.charAt(i)!=' '){
                word+=s.charAt(i);
                i++;
            }

            newString+=reverse(word)+" ";
        }

        return newString.trim();
    }
}