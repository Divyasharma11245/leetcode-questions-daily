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
    private TreeNode findIS(TreeNode root){
        TreeNode ans = null;
        if(root==null) return null;
        while(root!=null){
        ans = root;
        root=root.left;
        }
        return ans;
        
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val>key) root.left = deleteNode(root.left, key);
        if(root.val<key) root.right = deleteNode(root.right, key);
        if(root.val==key){
            if(root.left==null&&root.right==null){
                return null;
            }

            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }

            TreeNode IS = findIS(root.right);
            root.val = IS.val;
            root.right = deleteNode(root.right, IS.val);
        }
        return root;
    }
}