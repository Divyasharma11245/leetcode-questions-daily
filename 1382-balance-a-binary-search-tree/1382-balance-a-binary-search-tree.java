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
    private List<Integer> inorder(TreeNode root, List<Integer> list){
        if(root==null){
            return list;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        return list;
    }

    private TreeNode createBST(List<Integer> list, int si, int ei){
        if(si>ei){
            return null;
        }

        int mid = (si+ei)/2;
        TreeNode newRoot = new TreeNode(list.get(mid));
        newRoot.left = createBST(list, si, mid-1);
        newRoot.right = createBST(list, mid+1, ei);
        
        return newRoot;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        return createBST(list, 0, list.size()-1);
             
    }
}