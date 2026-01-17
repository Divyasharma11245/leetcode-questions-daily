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
    private void printPath(TreeNode root, String s, List<String> list ){
        if(root==null){
            return ;
        }
        if (s.length() == 0) {
            s += root.val;
        } else {
            s += "->" + root.val;
        }
        if(root.left==null&&root.right==null){
            list.add(s);
        }
        printPath(root.left, s, list);
        printPath(root.right, s, list);
        
    }
    public List<String> binaryTreePaths(TreeNode root) {
         List<String> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        String s = "";
        printPath(root, s, list);
        return list;
    }
}