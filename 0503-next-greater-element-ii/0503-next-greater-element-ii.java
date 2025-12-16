class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i = (2*n-1); i>=0; i--){
            while(!s.isEmpty()&&nums[s.peek()]<=nums[i%n]){
                s.pop();
            }

            if(s.isEmpty()){
                ans[i%n] = -1;
            }else{
                ans[i%n] = nums[s.peek()];
            }

            s.push(i%n);
        }
        return ans;
    }
}