class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int column = encodedText.length()/rows;
        StringBuilder origText = new StringBuilder();
        for(int col=0; col<column; col++){
            for(int j = col; j<encodedText.length(); j+=(column+1)){
                origText.append(encodedText.charAt(j));
            }
        }
        int i = origText.length() - 1;
        while (i >= 0 && origText.charAt(i) == ' ') {
            i--;
        }

        return origText.substring(0, i + 1);
    }
}