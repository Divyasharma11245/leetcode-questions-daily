class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer actualIdx[] = new Integer[n];
        for(int i =0; i<n; i++){
            actualIdx[i] = i;
        }
        Arrays.sort(actualIdx, (a,b)->{
            return positions[a]-positions[b];
        });
        Stack<Integer> st = new Stack<>();
        for(int i =0; i<n; i++){
            int idx = actualIdx[i];
            if(directions.charAt(idx)=='R'){
                st.push(idx);
            }else{
                while(!st.isEmpty()&&healths[idx]>0){
                   int curr =  st.pop();
                   if(healths[curr]>healths[idx]){
                    healths[idx] = 0;
                    healths[curr]--;
                    st.push(curr);
                   }else if(healths[curr]<healths[idx]){
                    healths[idx]--;
                    healths[curr] = 0;
                   }else{
                    healths[curr] =0;
                    healths[idx] = 0;
                   }
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(healths[i]!=0){
                list.add(healths[i]);
            }
        }
        return list;
    }
}