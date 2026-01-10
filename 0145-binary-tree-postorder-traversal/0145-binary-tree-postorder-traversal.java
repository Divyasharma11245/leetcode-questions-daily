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
    private TreeNode postorder(TreeNode root, List<Integer> list){
        if(root==null){
            return root;
        }

        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
        return root;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root==null){
            return list;
        }
        postorder(root, list);
        return list;
    }
}