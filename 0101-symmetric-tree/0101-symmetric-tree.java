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
    private boolean check(TreeNode right, TreeNode left){
        if(right==null&&left==null) return true;
        if(right==null||left==null) return false;
        if((right.val==left.val)&&check(right.left, left.right)&&check(right.right, left.left)) return true;
        return false;
    }
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }
}