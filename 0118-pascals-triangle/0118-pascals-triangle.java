class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i<numRows; i++){
            List<Integer> outer = new ArrayList<>();
            outer.add(1);
            for(int j = 1; j<i; j++){
                outer.add(list.get(i - 1).get(j - 1)+list.get(i-1).get(j));
            }
            if(i>0) outer.add(1);
            list.add(outer);
        }
        return list;
    }
}