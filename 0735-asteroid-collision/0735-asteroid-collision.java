class Solution {
    public int[] asteroidCollision(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ;i<n; i++){
            if(nums[i]>0){
                st.push(nums[i]);
            }else{
                while(!st.isEmpty()&&st.peek()>0&&Math.abs(nums[i])>st.peek()) st.pop();
                if(!st.isEmpty()&&st.peek()==Math.abs(nums[i])) st.pop();
                else if(st.isEmpty()||st.peek()<0) st.push(nums[i]);
            }
        }
        while(!st.isEmpty()){
            list.add(st.pop());
        }
        Collections.reverse(list);
        int len = list.size();
        int res[] = new int[len];
        for(int i = 0; i<len; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}