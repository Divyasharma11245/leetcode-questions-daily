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
    private TreeNode findPred(TreeNode root){
        TreeNode temp = root.left;
        while(temp.right!=null){
            temp = temp.right;
        }
        return temp;
    }
    private TreeNode findParPred(TreeNode root, TreeNode pred){
        if(pred==root.left) return root;
        TreeNode temp = root.left;
        while(temp.right!=pred){
            temp  = temp.right;
        }
        return temp;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val==key){
            if(root.left==null&&root.right==null) return null;
            else if(root.left==null||root.right==null){
                if(root.left==null) return root.right;
                else return root.left;
            }else{
                TreeNode pred = findPred(root);
                TreeNode predPar = findParPred(root, pred);
                if(predPar==root){
                    pred.right = root.right;
                    return pred;
                }
                predPar.right = pred.left;
                pred.left = root.left;
                pred.right = root.right;
                return pred;
            }
        }else if(root.val>key){
            root.left = deleteNode(root.left, key);
        }else{
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}