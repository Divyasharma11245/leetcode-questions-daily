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
    private ListNode findNthNode(ListNode head, int k){
        ListNode temp = head;
        int count = 1;
        while(temp!=null){
            if(count==k) return temp;
            count++;
            temp = temp.next;
        }
        return null;
    }
    public ListNode rotateRight(ListNode head, int k) {
        int len = 1;
        ListNode tail = head;
        if(head==null||head.next==null) return head;
        while(tail.next!=null){
            len++;
            tail = tail.next;
        }
        if(k%len==0) return head;
        k = k%len;
        tail.next = head;
        ListNode newlastNode = findNthNode(head, len-k);
        head = newlastNode.next;
        newlastNode.next = null;
        return head;
    }
}