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
        TreeNode node;
        int col;
        int row;
        Pair(int col, int row, TreeNode node){
            this.col = col;
            this.row = row;
            this.node = node;
        }
    }
    List<int[]> list;
    private  void bfs(TreeNode root){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, root));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            TreeNode currNode = curr.node;
            int currRow = curr.row;
            int currCol = curr.col;
            list.add(new int[]{currCol, currRow, currNode.val});
            if(currNode.left!=null) q.add(new Pair(currCol-1, currRow+1, currNode.left));
            if(currNode.right!=null) q.add(new Pair(currCol+1, currRow+1, currNode.right));
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        list = new ArrayList<>();
        bfs(root);
        Collections.sort(list, ((a, b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            else if(a[1]!=b[1]) return a[1]-b[1];
            else return a[2]-b[2];
        }));
        List<List<Integer>> ans = new ArrayList<>();
        int prev = Integer.MIN_VALUE;
        for(int[] curr :list){
            if(curr[0]!=prev){
                ans.add(new ArrayList<>());
                prev = curr[0];
            }
            ans.get(ans.size()-1).add(curr[2]);
        }
        return ans;
    }
}