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
    class Pair{
        int idx;
        TreeNode node;
        Pair(int idx, TreeNode node){
            this.idx = idx;
            this.node = node;
        }
    }
    int maxWidth;
    private void bfs(TreeNode root){
        if(root==null) return;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        while(!q.isEmpty()){
            int size = q.size();
            int front = 0;
            int back = 0;
            for(int i = 0; i<size; i++){
            Pair curr= q.poll();
            int currIdx = curr.idx;
            if(i==0) front = curr.idx;
            if(i==size-1) back = curr.idx;
            TreeNode currNode = curr.node;
            if(currNode.left!=null) q.offer(new Pair(2*currIdx+1, currNode.left));
            if(currNode.right!=null) q.offer(new Pair(2*currIdx+2, currNode.right)); 
            }
            maxWidth = Math.max(maxWidth, back-front+1);
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        maxWidth =  Integer.MIN_VALUE;
        bfs(root);
        return maxWidth;

    }
}