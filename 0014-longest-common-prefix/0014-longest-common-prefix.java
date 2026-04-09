class Solution {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        

        for(int i = 1; i<strs.length; i++){
            String second = strs[i];

                String ans = "";

            int len = Math.min(first.length(), second.length());
            for(int j = 0; j<len; j++){
                 if (first.charAt(j) == second.charAt(j)) {
                    ans += first.charAt(j);
                } else {
                    break;
                }
            }
            first=ans;

            if(first.equals("")) return "";
        }

        
        return first;
    }
}