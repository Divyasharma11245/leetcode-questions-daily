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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        TreeNode temp = root;
        if(temp==null) return node;
        if(temp.val>=val){
            if(temp.left==null){
                temp.left = node;
            }else{
                insertIntoBST(temp.left, val);
            }
        }else{
            if(temp.right==null){
                temp.right=node;
            }else{
                insertIntoBST(temp.right, val);
            }
        }
        return root;
    }
}