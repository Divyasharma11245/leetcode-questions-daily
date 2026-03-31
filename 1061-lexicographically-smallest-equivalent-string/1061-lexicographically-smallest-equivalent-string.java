class Solution {
    private char dfsUtil(ArrayList<Character> adj[], char curr, boolean vis[]){
        vis[curr-'a'] = true;
        char minChar = curr;
        for(char v: adj[curr-'a']){
            if(vis[v-'a']==false){
                minChar = (char)Math.min(minChar,dfsUtil(adj, v, vis));
            }
        }
        return minChar;
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        int m = baseStr.length();
        
        ArrayList<Character> adj[] = new ArrayList[26];
        for(int i =0; i<26; i++){
            adj[i] = new ArrayList();
        }
        for(int i = 0; i<n; i++){
            char u = s1.charAt(i);
            char v = s2.charAt(i);
            adj[u-'a'].add(v);
            adj[v-'a'].add(u);
        }

        String ans = "";
        for(int i = 0; i<m; i++){
            char ch = baseStr.charAt(i);
            boolean vis[] = new boolean[26];
            char minChar = dfsUtil(adj, ch, vis);
            ans+=minChar;
        }

        return ans;
    }
}