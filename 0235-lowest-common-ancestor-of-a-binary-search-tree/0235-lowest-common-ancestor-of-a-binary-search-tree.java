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
    private boolean ifPresent(TreeNode root, TreeNode curr){
        if(root==curr) return true;
        if(root==null) return false;
        // if(root.val>curr.val){
        //     ifPresent(root.left, curr);
        // }else{
        //     ifPresent(root.right, curr);
        // }
        // return false;
        return ifPresent(root.left, curr)||ifPresent(root.right, curr);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        // if(root.left==null||root.right==null) return null;
        if(p.val==root.val||q.val==root.val) return root;
        if(ifPresent(root.left, p)&&!ifPresent(root.left, q)){
            return root;
        }else if(!ifPresent(root.left, p)&&!ifPresent(root.left, q)) return lowestCommonAncestor(root.right, p, q);
        else if(ifPresent(root.left, q)&&!ifPresent(root.left, p)) return root;
        else if(ifPresent(root.left, p)&&ifPresent(root.left, q)) return lowestCommonAncestor(root.left, p, q); 
        return root;
    }
}