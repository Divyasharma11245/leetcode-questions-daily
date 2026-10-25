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
    private int level(TreeNode root){
        if(root==null) return 0;
        int left = level(root.left);
        int right = level(root.right);
        return Math.max(right, left)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int leftLevel = level(root.left);
        int rightLevel = level(root.right);
        if(Math.abs(leftLevel-rightLevel)>1) return false;
        return isBalanced(root.left)&&isBalanced(root.right);
    }
}