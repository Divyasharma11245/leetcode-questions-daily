class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int curr =0;
        int maxCount = 0;
        for(int i = 0; i<n; i++){
            if(s.charAt(i)=='('){
                curr++;
                maxCount = Math.max(maxCount, curr);
            }else if(s.charAt(i)==')'){
                curr--;
            }else{
                continue;
            }
        }
        return maxCount;
    }
}