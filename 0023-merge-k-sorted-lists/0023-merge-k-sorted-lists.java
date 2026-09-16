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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ListNode dummy = new ListNode(-1);
        ListNode k = dummy;
        for(ListNode list : lists){
            ListNode temp = list;
            while(temp!=null){
                pq.add(temp.val);
                temp = temp.next;
            }
        }
        while(pq.size()>0){
            ListNode node = new ListNode(pq.remove());
            k.next = node;
            k = k.next;
        }
        return dummy.next;
    }
}