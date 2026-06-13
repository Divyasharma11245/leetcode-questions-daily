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
    int max = Integer.MIN_VALUE;
    public int path(TreeNode root){
        if(root==null) return 0;
        int leftSum = Math.max(0, path(root.left));
        int rightSum = Math.max(0, path(root.right));
        max = Math.max(max, leftSum+rightSum+root.val);
        return root.val+Math.max(leftSum, rightSum);
    }
    public int maxPathSum(TreeNode root) {
        int path = path(root);
        return max;
    }
}