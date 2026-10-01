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
        int leftLevel = level(root.left);
        int rightLevel = level(root.right);
        return Math.max(leftLevel, rightLevel)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int leftH = level(root.left);
        int rightH = level(root.right);   
        int diff = Math.abs(leftH- rightH);
        if(diff>1) return false;
        return isBalanced(root.left)&&isBalanced(root.right);
        
        }
}