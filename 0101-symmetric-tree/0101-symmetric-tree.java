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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root.left);
        q2.offer(root.right);
       
        while(!q1.isEmpty()&&!q2.isEmpty()){
            TreeNode leftCurr = q1.poll();
            TreeNode rightCurr = q2.poll();
            if(leftCurr==null&&rightCurr==null) continue;
            if(leftCurr==null||rightCurr==null) return false;
            if(leftCurr.val!=rightCurr.val) return false;
            q1.offer(leftCurr.left);
            q2.offer(rightCurr.right);
            q1.offer(leftCurr.right);
            q2.offer(rightCurr.left);
        }
        return true;
    }
}