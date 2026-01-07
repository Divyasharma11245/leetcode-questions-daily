class Solution {
    public String maximumNumber(String num, int[] change) {
        int[] arr = new int[num.length()];

        for (int i = 0; i < num.length(); i++) {
            arr[i] = num.charAt(i) - '0';
        }

        boolean started = false;

        for(int i = 0; i<arr.length; i++){
            if(!started){
                if(change[arr[i]]>arr[i]){
                started = true;
                arr[i] = change[arr[i]];
            }
           }else{
            if(change[arr[i]]>=arr[i]){
                arr[i] = change[arr[i]];
            }else{
                break;
            }
           } 
        }

        StringBuilder ans = new StringBuilder();
        for (int d : arr) ans.append(d);

        return ans.toString();
    }
}