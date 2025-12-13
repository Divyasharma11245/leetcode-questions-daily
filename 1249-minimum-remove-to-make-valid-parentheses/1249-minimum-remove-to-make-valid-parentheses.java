class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        boolean remove[] = new boolean[s.length()];

        for(int i = 0; i<s.length(); i++){
           if(s.charAt(i)=='('){
            st.push(i);
           } else if(s.charAt(i)==')'){
            if(st.isEmpty()){
                remove[i] = true;
            }else{
                st.pop();
            }
           }
        }

        while(!st.isEmpty()){
            remove[st.pop()] = true;
        }

        String ans = "";
        for(int i= 0 ;i <s.length(); i++){
            if(!remove[i]){
                ans+=s.charAt(i);
            }
        }

        return ans;
    }
}