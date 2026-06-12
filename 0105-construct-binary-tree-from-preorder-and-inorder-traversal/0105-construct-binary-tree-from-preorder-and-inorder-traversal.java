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
    int preIndx = 0;
    private int search(int[] inorder, int left, int right, int key){
        for(int i = left; i<=right; i++){
            if(inorder[i]==key) return i;
        }
        return -1;
    }
    private TreeNode build(int[] preorder, int[] inorder, int left, int right){
        if(left > right) return null;
        TreeNode root = new TreeNode(preorder[preIndx++]);
        int inIndx = search(inorder, left, right, root.val);
        root.left = build(preorder, inorder, left, inIndx-1);
        root.right = build(preorder, inorder, inIndx+1, right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return build(preorder, inorder, 0, inorder.length-1);
    }
}