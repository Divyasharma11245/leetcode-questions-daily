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
    private TreeNode preorder(TreeNode root, List<Integer> list){
        if(root==null){
            return root;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);

        return root;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root==null){
            return list;
        }

        preorder(root, list);

        return list;
    }
}