class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)){
            return 1;
        }
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;

        q.add(beginWord);

        int ans = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                char[] curr = q.poll().toCharArray();

                for(int j = 0; j<curr.length; j++){
                    char ch = curr[j];

                    for(char c = 'a'; c<='z'; c++){
                        curr[j] = c;

                        String word = String.valueOf(curr);
                        if(word.equals(endWord)){
                            return ans+1;
                        }
                        if(set.contains(word)){
                            set.remove(word);
                            q.add(word);
                        }
                    }
                    curr[j] = ch;
                }
            }
           ans++; 
        }
        return 0;
    }
}