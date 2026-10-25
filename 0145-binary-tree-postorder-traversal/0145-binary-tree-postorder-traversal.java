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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode temp = root;
        while(temp!=null||!st.isEmpty()){
            while(temp!=null){
                st.push(temp);
                temp = temp.left;
            }
            if(st.peek().right!=null){
                temp = st.peek().right;
            }else{
                TreeNode node = st.pop();
                ans.add(node.val);
                while(!st.isEmpty()&&node==st.peek().right){
                    node = st.pop();
                    ans.add(node.val);
                }
            }
        }
        return ans;
    }
}