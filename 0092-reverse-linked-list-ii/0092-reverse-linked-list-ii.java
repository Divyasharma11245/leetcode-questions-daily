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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
    

    ListNode curr = head;
    ListNode leftPrev = dummy;
    int i = 0;
    while( i<left-1){
        curr = curr.next;
        leftPrev = leftPrev.next;
        i++;
    } 
    

    ListNode start = curr;

    ListNode prev = null;
    int j = 0;
    while(j<right-left+1){
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        j++;
    }

    leftPrev.next = prev;
    start.next = curr;

    return dummy.next;
    }
}