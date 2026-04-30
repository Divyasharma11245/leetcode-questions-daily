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
    private List<TreeNode> solve(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if(start>end){
            list.add(null);
            return list;
        }
        if(start==end){
            TreeNode root = new TreeNode(start);
            list.add(root);
            return list;
        }

        for(int i =start; i<=end; i++){
            List<TreeNode> left = solve(start, i-1);
            List<TreeNode> right = solve(i+1, end);

            for(TreeNode leftroot: left){
                for(TreeNode rightroot: right){
                    TreeNode root = new TreeNode(i);
                    root.left = leftroot;
                    root.right = rightroot;
                    list.add(root);
                }
            }
        }
        return list;

    }
    public List<TreeNode> generateTrees(int n) {
        return solve(1, n);
    }
}