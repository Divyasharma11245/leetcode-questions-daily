class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = 0;
        int j = 0;
        int startIdx = -1;
        int minLength = Integer.MAX_VALUE;
        int count = 0;
        if(m>n) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        while(i<m){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
            i++;
        }
        i=0;
        while(j<n){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch)>=0) count++;
            }
            while(count==m){
                int len = j-i+1;
                if(len<minLength){
                    minLength = len;
                    startIdx = i;
                }
                char leftChar = s.charAt(i);
                if(map.containsKey(leftChar)){
                    map.put(leftChar, map.get(leftChar)+1);
                    if(map.get(leftChar)>0){
                        count--;
                    }
                }
                i++;
            }
            j++;
        }
        return startIdx == -1?"":s.substring(startIdx, startIdx+minLength);
    }
}