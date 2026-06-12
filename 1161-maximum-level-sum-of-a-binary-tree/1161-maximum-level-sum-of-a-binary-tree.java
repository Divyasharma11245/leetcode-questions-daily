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
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int resultLevel = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int currLevel = 1;
        while(!q.isEmpty()){
            int n = q.size();
            int sum = 0;
            while(n!=0){
                TreeNode temp = q.remove();
                sum+=temp.val;
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
                n--;
            }
            if(sum>maxSum){
                maxSum=sum;
                resultLevel = currLevel;
            }
            currLevel++;
        }
        return resultLevel;
    }
}