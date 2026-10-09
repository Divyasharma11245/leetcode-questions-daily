/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void findTree(TreeNode root, HashMap<TreeNode, TreeNode> map){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.left!=null){
                    map.put(curr.left, curr);
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    map.put(curr.right, curr);
                    q.offer(curr.right);
                }
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        findTree(root, map);
        HashSet<TreeNode> set = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        set.add(target);
        int currLevel = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(currLevel == k){
                break;
            }
            for(int i = 0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.left!=null&&set.add(curr.left)) q.offer(curr.left);
                if(curr.right!=null&&set.add(curr.right)) q.offer(curr.right);
                TreeNode par = map.get(curr);
                if(par!=null&&set.add(par)){
                    q.offer(par);
                }
            }
            currLevel++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int size = q.size();
        for(int i = 0; i<size; i++){
            list.add(q.poll().val);
        }
        return list;
    }
}