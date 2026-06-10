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
    int ans = 0;
    private int height(TreeNode root){
        if(root==null) return 0;
        int leftH = height(root.left);
        int rightH = height(root.right);
        int currH = Math.max(leftH,rightH)+1;
        ans = Math.max(leftH+rightH, ans);
        return currH;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return ans;
    }
}