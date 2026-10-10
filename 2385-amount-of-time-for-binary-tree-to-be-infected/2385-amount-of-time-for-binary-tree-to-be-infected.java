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
    private TreeNode findNode(TreeNode root, int start){
        if(root==null) return null;
        if(root.val==start) return root;
        TreeNode left = findNode(root.left, start);
        if(left!=null) return left;
        TreeNode right = findNode(root.right, start);
        return right;
    }
    HashMap<TreeNode, TreeNode> map = new HashMap<>();
    private void findPar(TreeNode root, TreeNode par){
        if(root==null) return;
        map.put(root,par);
        findPar(root.left, root);
        findPar(root.right, root);
    }
    public int amountOfTime(TreeNode root, int start) {
        HashSet<TreeNode> set = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        findPar(root, null);
        TreeNode target = findNode(root, start);
        if(target==null) return 0;
        q.offer(target);
        set.add(target);
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.left!=null&&set.add(curr.left)) q.offer(curr.left);
                if(curr.right!=null&&set.add(curr.right)) q.offer(curr.right);
                if(map.get(curr)!=null&&set.add(map.get(curr))) q.offer(map.get(curr));
            }
            time++;
        }
        return time-1;
    }
}