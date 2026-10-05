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
    int maxSum;
    private int solve(TreeNode root){
        if(root==null) return 0;
        int l = Math.max(0, solve(root.left));
        int r = Math.max(0, solve(root.right));

        int lowerPath = l+r+root.val;
        int onlyOne = Math.max(l, r)+root.val;
        int notAny = root.val;
        maxSum = Math.max(maxSum,Math.max(lowerPath, Math.max(onlyOne, notAny)));
        return Math.max(onlyOne, notAny);
    }
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}