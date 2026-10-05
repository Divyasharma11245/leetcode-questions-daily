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
    private void dfs(TreeNode root, String str, List<String> list){
        if(root.left==null&&root.right==null){
            list.add(str);
            return;
        }
        if(root.left!=null) dfs(root.left, str+"->"+root.left.val, list);
        if(root.right!=null) dfs(root.right, str+"->"+root.right.val, list);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, String.valueOf(root.val), list);
        return list;
    }
}