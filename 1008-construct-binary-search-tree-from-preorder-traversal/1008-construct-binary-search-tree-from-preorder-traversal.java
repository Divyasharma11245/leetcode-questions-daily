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
    HashMap<Integer, Integer> map = new HashMap<>();
    int preIdx = 0;
    private TreeNode build(int[] preorder, int[] inorder, int start, int end){
        if(start>end) return null;
        TreeNode node = new TreeNode(preorder[preIdx++]);
        int inIdx = map.get(node.val);
        node.left = build(preorder, inorder, start, inIdx-1);
        node.right = build(preorder, inorder, inIdx+1, end);
        return node;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = new int[preorder.length];
        for(int i = 0; i<preorder.length; i++){
            inorder[i]=preorder[i];
        }

        Arrays.sort(inorder);
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, inorder.length-1);
    }
}