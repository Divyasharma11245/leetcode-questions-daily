class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap <Character, Integer> map = new HashMap<>();

        if(s.length()!=t.length()){
            return false;
        }

        for(int i = 0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        for(int j = 0; j<t.length(); j++){
            if(map.isEmpty()||!map.containsKey(t.charAt(j))){
                return false;
            }else{
                map.put(t.charAt(j), map.getOrDefault(t.charAt(j), 1)-1);
                
            if(map.get(t.charAt(j))==0){
                    map.remove(t.charAt(j));
                }
        }
        }
        return true;
    }
}