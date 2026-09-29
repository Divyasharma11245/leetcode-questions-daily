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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode node = root;
        while(node!=null||!st.isEmpty()){
            while(node!=null){
                st.push(node);
                node = node.left;
            }
            node = st.pop();
            ans.add(node.val);
            node = node.right;
        }
        return ans;
    }
}