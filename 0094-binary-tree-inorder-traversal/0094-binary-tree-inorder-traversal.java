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
    private TreeNode inorder(TreeNode root, List<Integer>list){
        if(root==null){
            return root;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);

        return root;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        inorder(root, list);

        return list;
    }
}