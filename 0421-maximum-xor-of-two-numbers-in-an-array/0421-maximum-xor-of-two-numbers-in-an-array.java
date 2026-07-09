class Solution {
    class TrieNode{
        TrieNode left;;
        TrieNode right;

        TrieNode(){
            this.left = null;
            this.right = null;
        }
    }

    void insert(TrieNode root, int num){
        TrieNode pCrawl = root;
        for(int i = 31; i>=0; i--){
            int ith_bit = (num>>i)&1;
            if(ith_bit==0){
                if(pCrawl.left==null){
                    pCrawl.left = new TrieNode();
                }
            pCrawl = pCrawl.left;
            }else{
                if(pCrawl.right==null){
                    pCrawl.right = new TrieNode();
                }
                 pCrawl = pCrawl.right;
            }
        }
    }

    int findXor(int num, TrieNode root){
        TrieNode temp = root;
        int maxAns = 0;
        for(int i = 31; i>=0; i--){
            int ith_bit = (num>>i)&1;
            if(ith_bit==1){
                if(temp.left!=null){
                    maxAns |= (1 << i);
                    temp = temp.left;
                }else{
                    temp = temp.right;
                }
            }else{
                if(temp.right!=null){
                    maxAns |= (1 << i);
                    temp = temp.right;
                }else{
                    temp = temp.left;
                }
            }
        }
        return maxAns;
    }
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for(int i = 0; i<nums.length; i++){
            insert(root, nums[i]);
        }

        int maxAns = 0;
        for(int i = 0; i<nums.length; i++){
            int ans = findXor(nums[i], root);
            maxAns = Math.max(maxAns, ans);
        }

        return maxAns;
    }
}