class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        List<Character> buckets[] = new ArrayList[s.length()+1];

        for(Character key: map.keySet()){
            int freq = map.get(key);
            if(buckets[freq]==null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        String ans = "";
        for(int j = buckets.length-1; j>=0; j--){
            if(buckets[j]!=null){
                for(char pos: buckets[j]){
                    for(int count = 0; count<j; count++){
                        ans+=pos;
                    }
                    
                }
                
            }
        }
        return ans;
    }
}