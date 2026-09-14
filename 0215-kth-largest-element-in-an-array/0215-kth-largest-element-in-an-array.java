class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i<nums.length; i++){
            pq.add(nums[i]);
        }
        int i = 0;
        while(i<k-1){
            pq.remove();
            i++;
        }
        return pq.peek();
    }
}