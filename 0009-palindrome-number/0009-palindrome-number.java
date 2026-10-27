class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int temp = x;
        int rev = 0;
        while(temp!=0){
            int lastD = temp%10;
            temp = temp/10;
            rev = rev*10+lastD;
        }
        return x==rev;
    }
}