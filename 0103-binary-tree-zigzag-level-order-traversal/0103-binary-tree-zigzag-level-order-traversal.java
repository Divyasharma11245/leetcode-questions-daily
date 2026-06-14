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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        boolean flag = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> inner = new ArrayList<>();
            Stack<Integer> st = new Stack<>();
            for(int i = 0; i<size; i++){
                TreeNode node = q.poll();
                if(!flag) inner.add(node.val);
                else st.push(node.val);

                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            flag = !flag;
            while(!st.isEmpty()){
                inner.add(st.pop());
            }
            list.add(inner);
        }
        return list;
    }
}