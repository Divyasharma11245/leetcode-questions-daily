class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int hashArray[] = new int[26];
        for(int i = 0; i<s.length(); i++){
            hashArray[s.charAt(i)-'a']++;
        }

        for(int j = 0; j<t.length(); j++){
            if(hashArray[t.charAt(j)-'a']==0) return false;
            hashArray[t.charAt(j) - 'a']--;
        }
        return true;
    }
}