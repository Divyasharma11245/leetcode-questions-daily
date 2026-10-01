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
    static int diam;
    public int diam(TreeNode root){
        if(root==null) return 0;
        int leftLevel = diam(root.left);
        int rightLevel = diam(root.right);
        diam =  Math.max(diam, leftLevel+rightLevel);
        return 1+Math.max(leftLevel, rightLevel);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        diam = 0;
        diam(root);
        return diam;
    }
}