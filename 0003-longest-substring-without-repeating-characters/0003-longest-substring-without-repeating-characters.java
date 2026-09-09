class Solution {
    public int lengthOfLongestSubstring(String s) {
       int l = 0;
       int r = 0;
       int n = s.length();
       int maxLen = 0;
       Set<Character> set = new HashSet<>();
       while(r<n){
        while(set.contains(s.charAt(r))){
            set.remove(s.charAt(l));
            l++;
        }
        set.add(s.charAt(r));
        int len = r-l+1;
        maxLen = Math.max(maxLen, len);
        r++;
       }  
       return maxLen;       
    }
}