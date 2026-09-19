class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        int m = tasks.length;
        for(int i = 0; i<m; i++){
            freq[tasks[i]-'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i<26; i++){
            if(freq[i]>0) pq.add(freq[i]);
        }
        int time = 0;
        while(!pq.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
int executed = 0;
            for(int i = 0; i<n+1; i++){
                if(!pq.isEmpty()){
                    int curr = pq.remove();
                    curr--;
                    executed++;
                    if (curr > 0) {
                        list.add(curr);
                    }
                }

            }
            for(int i = 0; i<list.size(); i++){
                pq.add(list.get(i));
            }

            if(pq.isEmpty()) time+=executed;
            else time+=(n+1);
        }
            return time;
    }

}