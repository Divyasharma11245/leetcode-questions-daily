class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = num.length();
        for(int i = 0; i<n; i++){
            while(!st.isEmpty()&&k>0&&st.peek()-'0'>num.charAt(i)-'0'){
                st.pop();
                k=k-1;
            }
            st.push(num.charAt(i));
        }
        while(k>0){
            st.pop();
            k--;
        }
        if(st.isEmpty()){
            return "0";
        }
        while(!st.isEmpty()) sb.append(st.pop());
        while(sb.length()>0&&sb.charAt(sb.length()-1)=='0'){
            sb.deleteCharAt(sb.length()-1);
        }
        if(sb.length()==0){
            return "0";
        }
        sb = sb.reverse();
        return sb.toString();
    }
}