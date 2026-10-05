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
    List<int[]> list;
    class Pair{
        TreeNode root;
        int col;
        int row;
        Pair(TreeNode root, int col, int row){
            this .root = root;
            this.col = col;
            this.row = row;
        }
    }

    private void bfs(TreeNode root, int row, int col){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, row, col));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            TreeNode currRoot = curr.root;
            int currCol = curr.col;
            int currRow = curr.row;
            list.add(new int[]{currCol, currRow, currRoot.val});
            if(currRoot.left!=null) q.offer(new Pair(currRoot.left, currCol-1, currRow+1));
            if(currRoot.right!=null) q.offer(new Pair(currRoot.right, currCol+1, currRow+1));
        }
    }
    private void dfs(TreeNode root, int row, int col){
        if(root==null) return;
        list.add(new int[]{col, row, root.val});
        dfs(root.left, row+1, col-1);
        dfs(root.right, row+1, col+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        list = new ArrayList<>();
        bfs(root, 0, 0);
        Collections.sort(list, (a, b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            else if(a[1]!=b[1]) return a[1]-b[1];
            else return a[2]-b[2];
        });
        List<List<Integer>> ans = new ArrayList<>();
        int prev = Integer.MIN_VALUE;
        for(int[] node: list){
            if(node[0]!=prev){
                ans.add(new ArrayList<>());
                prev=node[0];
            }
            ans.get(ans.size()-1).add(node[2]);
        }
        return ans;
    }
}