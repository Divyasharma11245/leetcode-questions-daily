class Solution {
    private boolean isDigit(char c){
        return c>='0'&&c<='9';
    }
    public int myAtoi(String s) {
        int i = 0;
        int num = 0;
        while(i<s.length()&&s.charAt(i)==' '){
            i++;
        }
        int sign = 1;
        if(i<s.length()){
            if(s.charAt(i)=='-'){
                sign = -1;
                i++;
            }else if(s.charAt(i)=='+'){
                i++;
            }
        }

        while(i<s.length()){
            // int digit = s.charAt(i)-'0';
            if(isDigit(s.charAt(i))){
                int digit = s.charAt(i)-'0';
                if(num>Integer.MAX_VALUE/10||num==Integer.MAX_VALUE/10&&digit>7) return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                num = num*10+digit;
            }else{
                break;
            }
            i++;
        }
        return num*sign;
    }
}