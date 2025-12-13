class Solution {
    public int minAddToMakeValid(String s) {
        Stack <Character> st = new Stack<>();
        int extra = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            }else{
                if(!st.isEmpty()){
                    if(s.charAt(i)==')')  st.pop();
                }else{
                    extra++;
                }
            }
        }
        return extra+st.size();
    }
}