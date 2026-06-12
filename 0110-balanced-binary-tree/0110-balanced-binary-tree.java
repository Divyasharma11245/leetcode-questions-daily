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
    private int height(TreeNode root){
        if(root==null) return 0;
        int leftH = height(root.left);
        int rightH = height(root.right);
        return Math.max(leftH, rightH)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int leftH = height(root.left);
        int rightH = height(root.right);
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        return Math.abs(leftH - rightH) <= 1 && left && right;
    }
}