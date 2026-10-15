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
    int i = 0;
    private TreeNode build(int[] preorder, int upperbound){
        if(i==preorder.length||preorder[i]>upperbound){
            return null;
        }
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = build(preorder, root.val);
        root.right = build(preorder, upperbound);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }
}