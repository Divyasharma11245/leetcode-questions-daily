class Solution {
    class Info implements Comparable<Info>{
        int val;
        int index;
        Info(int v, int i){
            this.val = v;
            this.index = i;
        }
        @Override
        public int compareTo(Info info){
            return this.val-info.val;
        }
    }
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        PriorityQueue<Info> pq = new PriorityQueue<>();
        for(int i =0 ;i<n; i++){
            pq.add(new Info(arr[i], i));
        }

        int[] ans = new int[n];
        int rank = 0;
        int prev = Integer.MIN_VALUE;

        while (!pq.isEmpty()) {
            Info curr = pq.remove();

            if (rank == 0 || curr.val != prev) {
                rank++;
                prev = curr.val;
            }

            ans[curr.index] = rank;
        }

        return ans;
    }
}