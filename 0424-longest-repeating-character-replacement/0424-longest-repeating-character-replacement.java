class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int n = s.length();
        int maxLen = 0;
        int maxFreq = 0;
        int hash[] = new int[26];
        while(r<n){
            char ch = s.charAt(r);
            hash[ch-'A']++;
            maxFreq = Math.max(maxFreq, hash[ch-'A']);
            int change = (r-l+1)-maxFreq;
            while(change>k){
                hash[s.charAt(l) - 'A']--;
                maxFreq = 0;
                for(int i = 0; i<26; i++){
                    maxFreq = Math.max(maxFreq, hash[i]);
                    
                }
                l=l+1;
                change = (r-l+1) - maxFreq;
            }
            if((r-l+1) - maxFreq <= k){
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }
}