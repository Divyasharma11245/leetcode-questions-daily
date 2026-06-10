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
        int currH = Math.max(leftH,rightH)+1;
        return currH;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int leftDaim = diameterOfBinaryTree(root.left);
        int rightDiam = diameterOfBinaryTree(root.right);
        int currD = height(root.left)+height(root.right);
        int diam = Math.max(leftDaim, Math.max(rightDiam, currD));
        return diam;
    }
}