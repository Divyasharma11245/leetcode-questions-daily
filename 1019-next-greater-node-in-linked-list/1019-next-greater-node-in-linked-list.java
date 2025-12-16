/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
        list.add(temp.val);
        temp = temp.next;
        }

        Stack<Integer> s = new Stack<>();
        int ans[] = new int[list.size()];
        temp = head;
        for(int i=list.size()-1; i>=0; i--){
            while(!s.isEmpty()&&list.get(s.peek())<=list.get(i)){
                s.pop();
            }

            if(s.isEmpty()){
                ans[i] = 0;
            }else{
                ans[i] = list.get(s.peek());
            }
            s.push(i);
        }
        return ans;
    }
}