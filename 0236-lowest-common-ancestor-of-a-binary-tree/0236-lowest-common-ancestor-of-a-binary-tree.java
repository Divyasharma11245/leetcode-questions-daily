/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean existInLeft(TreeNode root, TreeNode p){
        if(root==null&&p==null) return true;
        if(root==null||p==null) return false;
        if(root.val==p.val) return true;
        return existInLeft(root.left, p)||existInLeft(root.right, p);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(p==root||q==root) return root;
        boolean pInLeft = existInLeft(root.left, p);
        boolean qInLeft = existInLeft(root.left, q);
        if(pInLeft&&!qInLeft) return root;
        if(!pInLeft&&qInLeft) return root;
        if(pInLeft&&qInLeft) return  lowestCommonAncestor(root.left, p, q);
        if(!pInLeft&&!qInLeft) return lowestCommonAncestor(root.right, p, q);
        return root;

    }
}