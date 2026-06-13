/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        TreeNode node;
        long idx;
        Pair(TreeNode node, long idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int maxWidth = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int n = q.size();
            long minIdx = q.peek().idx;
            long first = 0, last = 0;
            for (int i = 0; i < n; i++) {
                Pair curr = q.poll();
                long idx = curr.idx - minIdx;

                if (i == 0) first = idx;
                if (i == n - 1) last = idx;
                if(curr.node.left!=null) q.add(new Pair(curr.node.left, 2*idx+1));
                if(curr.node.right!=null) q.add(new Pair(curr.node.right, 2*idx+2));
            }
            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
        }
        return maxWidth;
    }
}