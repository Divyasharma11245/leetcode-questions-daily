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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        if(head.next==null&&n==1) return null;
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        int res = count-n;
         if (res == 0) {
            return head.next;
        }
        temp = head;
         while (res > 1) {
            temp = temp.next;
            res--;
        }
        temp.next = temp.next.next;
        return head;
    }
}