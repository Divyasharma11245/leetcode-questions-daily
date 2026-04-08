class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        long MOD = 1000000007;

        long[] mul = new long[n];
        Arrays.fill(mul, 1);

        // accumulate multipliers
        for(int[] q : queries){
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

            for(int i = l; i <= r; i += k){
                mul[i] = (mul[i] * v) % MOD;
            }
        }

        int xor = 0;

        // apply once
        for(int i = 0; i < n; i++){
            long val = (nums[i] * mul[i]) % MOD;
            xor ^= (int)val;
        }

        return xor;
    }
}