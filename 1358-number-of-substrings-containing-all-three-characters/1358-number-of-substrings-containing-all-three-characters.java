class Solution {
    public int numberOfSubstrings(String s) {
       int i = 0;
       int j = 0;
       int n = s.length();
       HashMap<Character, Integer> map = new HashMap<>();
       int ans = 0;
       while(j<n){
        char ch = s.charAt(j);
        map.put(ch, map.getOrDefault(ch, 0)+1);
        while(map.size()>=3){
            ans+=n-j;
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)-1);
            if(map.get(s.charAt(i))==0){
                map.remove(s.charAt(i));
            }
            i++;
        } 
        
        j++;
       } 
       return ans;
    }
}