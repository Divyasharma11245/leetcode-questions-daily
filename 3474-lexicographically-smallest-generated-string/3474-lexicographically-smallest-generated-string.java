class Solution {
    private boolean isSame(String str, char ans[], int i, int m){
        for(int j = 0; j<m; j++){
            if(ans[i+j]!=str.charAt(j)){
                return false;
            }
        }
        return true;
    }
    public String generateString(String str1, String str2) {
       int n = str1.length();
       int m = str2.length(); 

       char ans[] = new char[n+m-1];
       boolean canChange[] = new boolean[n+m-1];
       Arrays.fill(canChange, false); 
       Arrays.fill(ans, '$');
       for(int i = 0; i<n; i++){
            if(str1.charAt(i)=='T'){
                int idx = i;
                for(int j = 0; j<m; j++){
                    if(ans[idx]!='$'&&ans[idx]!=str2.charAt(j)){
                        return "";
                    }
                    ans[idx] = str2.charAt(j);
                    idx++;
                }
            }
        }

        for(int i = 0; i<ans.length; i++){
            if(ans[i]=='$'){
                ans[i] = 'a';
                canChange[i] = true;
            }
        }

        for(int i = 0; i<=ans.length-m; i++){
            if(str1.charAt(i)=='F'){
                if(isSame(str2, ans, i, m)){
                    boolean changed = false;
                    for(int k = i+m-1; k>=i; k--){    
                        if(canChange[k]==true){
                            ans[k] = 'b';
                            changed = true;
                            break;
                        }
                    }
                    if(!changed){
                        return "";
                    }
                }
            }
        }
        return new String(ans);
    }
}