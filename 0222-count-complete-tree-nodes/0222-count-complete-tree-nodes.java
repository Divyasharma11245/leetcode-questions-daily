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
    private int leftHeight(TreeNode root){
        int count = 0;
        TreeNode temp = root;
        while(temp!=null){
            temp = temp.left;
            count++;
        }
        return count;
    }
    private int rightHeight(TreeNode root){
        int count = 0;
        TreeNode temp = root;
        while(temp!=null){
            temp = temp.right;
            count++;
        }
        return count;
    }
    public int countNodes(TreeNode root) {
        int left = leftHeight(root);
        int right = rightHeight(root);
        if(left==right){
            return (1<<left)-1;
        }else{
            int leftCount = countNodes(root.left);
            int rightCount = countNodes(root.right);
            return leftCount+rightCount+1;
        }
    }
} 