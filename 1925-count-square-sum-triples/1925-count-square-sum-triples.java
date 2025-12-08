class Solution {
    public int countTriples(int n) {

        int count = 0;

        for(int i = 1; i <= n; i++){
            for(int j = i + 1; j <= n; j++){

                int sum = i*i + j*j;

                int root = (int)Math.sqrt(sum);

                if(root * root == sum && root <= n){
                    count += 2;  
                }
            }
        }

        return count;
    }
}
