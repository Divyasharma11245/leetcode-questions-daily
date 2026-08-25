class Solution {
    private void solve(String digits, int idx, StringBuilder temp, ArrayList<String> list, HashMap<Character, String> map){
        if(idx>=digits.length()){
            list.add(temp.toString());
            return;
        }

        String str = map.get(digits.charAt(idx));
        for(int i = 0; i<str.length(); i++){
            temp.append(str.charAt(i));
            solve(digits, idx+1, temp, list, map);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        // if(digits.length()==1&&digits.charAt(i)==1) return new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        ArrayList<String> list = new ArrayList<>();

        StringBuilder temp = new StringBuilder();
        solve(digits, 0, temp, list, map);
        return list;

    }
}