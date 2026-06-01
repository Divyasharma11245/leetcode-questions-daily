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
    private ListNode findLastNode(ListNode temp, int len){
        int count  = 1;
        while(temp!=null){
            if(count==len) return temp;
            count++;
            temp = temp.next;
        }
        return temp;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0) return head;
        ListNode tail = head;
        int len = 1;
        while(tail.next!=null){
            tail = tail.next;
            len++;
        }
        if(k%len==0) return head;
        k = k%len;
        tail.next = head;
        ListNode newLastNode = findLastNode(head, len-k);
        head = newLastNode.next;
        newLastNode.next = null;
        return head;
    }

}