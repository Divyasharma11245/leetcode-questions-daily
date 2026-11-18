class Solution {
    class Pair{
        String word;
        int step;
        Pair(String word, int step){
            this.word = word;
            this.step = step;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for(int i= 0; i<wordList.size(); i++){
            set.add(wordList.get(i));
        }
        q.add(new Pair(beginWord, 1));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            String currWord = curr.word;
            int currStep = curr.step;
            if(currWord.equals(endWord)) return currStep;
            for(char ch = 'a'; ch<='z'; ch++){
                for(int i = 0; i<currWord.length(); i++){
                    char currWordArr[] = currWord.toCharArray();
                    currWordArr[i] = ch;
                    String currNewWord = new String(currWordArr);
                if(set.contains(currNewWord)){
                    set.remove(currNewWord);
                    q.add(new Pair(currNewWord, currStep+1));
                }
                }

            }
        }
        return 0;
    }
}