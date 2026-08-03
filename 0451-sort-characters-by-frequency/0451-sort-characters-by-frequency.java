class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        ArrayList<Character> arr[] = new ArrayList[s.length()+1];

        for(char ch:map.keySet()){
            int freq = map.get(ch);
            if(arr[freq]==null){
                arr[freq] = new ArrayList<>();
            }
            arr[freq].add(ch);
        }

       StringBuilder ans = new StringBuilder();

        for (int i = s.length(); i >= 1; i--) {

            if (arr[i] == null) continue;

            for (char ch : arr[i]) {
                for (int j = 0; j < i; j++) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }
}