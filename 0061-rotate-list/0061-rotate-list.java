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
    public ListNode rotateRight(ListNode head, int k) {
        int size = 0;

        if(head==null||head.next == null){
            return head;
        }

        ListNode temp = head;
        while(temp!=null){
            size++;
            temp = temp.next;
        }

        k = k % size;
        if (k == 0) return head;

        temp = head;
        while(temp.next!=null ){
            temp = temp.next;
        }

        temp.next = head;
        ListNode tail = head;
        int j = 0;
        while( j<(size-k-1)){
            tail=tail.next;
            j++;
        }

        head = tail.next;
        tail.next = null;
        return head;
    }
}