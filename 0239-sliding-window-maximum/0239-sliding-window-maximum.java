class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=  0; i<n; i++){
            if(!dq.isEmpty()&&dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty()&&nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1){
                list.add(nums[dq.peekFirst()]);
            }
        }
        int len = list.size();
        int res[] = new int[len];
        for(int i = 0 ;i<len; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}